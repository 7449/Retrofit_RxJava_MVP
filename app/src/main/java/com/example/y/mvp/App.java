package com.example.y.mvp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * by y on 2017/3/3
 */

public class App extends Application {


    @SuppressLint("StaticFieldLeak")
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
