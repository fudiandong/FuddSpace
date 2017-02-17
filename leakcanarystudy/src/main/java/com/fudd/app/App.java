package com.fudd.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by fudd-office on 2017-2-17 17:08.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);

    }
}
