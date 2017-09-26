/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Umeng, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.mvpdemo.view;

//import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.data.Article;
import com.example.mvpdemo.presenter.ArticlePresenter;
import com.example.mvpdemo.view.inf.ArticleViewInterface;

/**
 * 用fragment作为UI View
 * View包含一个presenter的实例的引用。
 */
public class ArticlesFragment extends Fragment
        implements SwipeRefreshLayout.OnRefreshListener, ArticleViewInterface {

    // UI界面所包含的presenter的实例的引用
    private ArticlePresenter mPresenter;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView tv_title;
    private TextView tv_content;

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container,
                                   Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        initRefreshView(rootView);
        /*initPresenter();*/
        mPresenter = new ArticlePresenter(this);
        fetchData();
        return rootView;
    }

    protected void initRefreshView(View rootView) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        tv_title = (TextView)rootView.findViewById(R.id.tv_title);
        tv_content = (TextView)rootView.findViewById(R.id.tv_refresh);
    }



    public void fetchData() {
        mPresenter.fetchArticles();
    }

    // 刷新控件操作
    @Override
    public void onRefresh() {
        mPresenter.fetchArticles();
    }

    @Override
    public void loadData(Article result) {
        tv_title.setText(result.getTitle());
        tv_content.setText(result.getContent());
    }

    @Override
    public void showRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
