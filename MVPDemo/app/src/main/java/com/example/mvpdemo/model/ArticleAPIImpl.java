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

package com.example.mvpdemo.model;

import android.os.SystemClock;
import com.example.mvpdemo.model.data.Article;
import com.example.mvpdemo.model.data.ArticlesHandler;


/**
 * 实现model数据操作接口ArticleAPI。
 *
 * 可以extend一个网络接口如AbsNetwork，这样获取数据的操作方式即可变成通过网络获取数据。
 * ArticleAPI中的实现直接调用由AbsNetwork提供的api就可以了。
 */
public class ArticleAPIImpl implements ArticleAPI<Article> {
    private ArticlesHandler handler;

    @Override
    public void fetchArticles(DataListener<Article> listener) {
        // 模拟获取数据时产生的延迟
        SystemClock.sleep(500);
        handler = new ArticlesHandler();
        listener.onFinish(handler.getArticle());
    }

    @Override
    public void loadMore(DataListener<Article> listener) {
        // 模拟获取数据产生的延迟
        SystemClock.sleep(500);
        handler = new ArticlesHandler();
        listener.onError(handler.getArticle());
    }
}
