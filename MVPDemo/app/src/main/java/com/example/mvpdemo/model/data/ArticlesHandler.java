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

package com.example.mvpdemo.model.data;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//import android.os.SystemClock;
//import java.text.ParseException;


/**
 * 产生模拟数据。
 *
 * 用模拟数据代替从网络获取数据。
 * */
public class ArticlesHandler {

    private String[] title = new String[] {
            "orange",
            "watermelon",
            "grape",
            "strawberry",
            "cherry",
            "pineapple",
            "mango"
    };

    private Article article;

    public ArticlesHandler() {
        article = new Article();
        article.setTitle(generateTitle());
        article.setContent(generateContent());
    }

    public Article getArticle() {
        return article;
    }

    @SuppressLint("SimpleDateFormat")
    private String generateTitle() {
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.format(currentDate);
    }

    private String generateContent() {
        Random random = new Random();
        int id = random.nextInt(title.length);
        return buildContent(title[id]);
    }

    /*
    @SuppressLint("SimpleDateFormat")
    private String formatDate(SimpleDateFormat dateFormat, String dateString) {
        try {
            Date date = dateFormat.parse(dateString);
            return dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }*/

    private String buildContent(String name) {
        StringBuilder article = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            article.append(name);
        }
        return article.toString();
    }
}
