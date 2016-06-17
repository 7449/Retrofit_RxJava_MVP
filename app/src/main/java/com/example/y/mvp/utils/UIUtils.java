package com.example.y.mvp.utils;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.y.mvp.activity.BaseActivity;


/**
 * by y on 2016/4/28.
 */
@SuppressWarnings("ALL")
public class UIUtils {


    public static Context getContext() {
        return BaseActivity.getContext();
    }

    public static Activity getActivity() {
        return BaseActivity.getActivity();
    }


    public static Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    public static int getColor(int id) {
        return getContext().getResources().getColor(id);
    }

    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }


    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }
}
