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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


/**
 * activity的基类。封装了添加/替换fragment的api。
 *
 * 其他activity直接继承基类就可以少写添加/替换fragment这部分代码
 * */
public class BasedToolBarActivity extends AppCompatActivity {
    protected Toolbar mToolbar;
    protected FragmentManager mFragmentManager;
    protected int mFrgContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        //Mob clickAgent.onPause(this);
    }*/

    protected void setFragmentContainer(int container) {
        mFrgContainer = container;
    }

    protected void addFragment(Fragment fragment) {
        mFragmentManager.beginTransaction().add(mFrgContainer, fragment).commit();
    }

    protected void replaceFragment(Fragment fragment) {
        mFragmentManager.beginTransaction().replace(mFrgContainer, fragment).commit();
    }
}
