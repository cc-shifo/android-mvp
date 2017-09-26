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

package com.example.mvpdemo.presenter;

//import android.annotation.SuppressLint;

import android.util.Log;

import com.example.mvpdemo.model.ArticleAPI;
import com.example.mvpdemo.model.ArticleAPIImpl;
import com.example.mvpdemo.model.DataListener;
import com.example.mvpdemo.model.data.Article;
import com.example.mvpdemo.view.inf.ArticleViewInterface;

/**
 * view和model的中间者。
 *
 * present包含model和view的引用，这样presenter自己的api就可以引用model以及view中的api
 */
public class ArticlePresenter {
    private static final String TAG = "ArticlePresenter";
    /**
     * 通过UI和model提供的接口，presenter可以操作UI和model
     * */
    // 操作数据的接口实例的引用，接口由model来实现
    private ArticleAPI<Article> mArticleApi = new ArticleAPIImpl();
    // 操作UI的接口实例的引用，接口由activity或fragment来实现
    private ArticleViewInterface mVI;


    public ArticlePresenter(ArticleViewInterface viewInterface) {
        mVI = viewInterface;
    }

    // 获取文章
    public void fetchArticles() {
        mVI.showRefresh();
        mArticleApi.fetchArticles(new DataListener<Article>() {

            @Override
            public void onFinish(Article result) {
                fetchDataFinished(result);
            }

            @Override
            public void onError(Article error) {
                mVI.hideRefresh();
            }
        });
    }

    private void fetchDataFinished(Article result) {
        if (result != null) {
            mVI.loadData(result);
        }

        mVI.hideRefresh();
    }
}
