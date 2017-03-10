package com.example.y.mvp.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * by y on 2016/5/17.
 * Activity管理类
 */

public class ActivityCollector {


    private static final List<Activity> list = new ArrayList<>();


    public static void addActivity(Activity activity) {
        list.add(activity);
    }

    public static void removeActivity(Activity activity) {
        list.remove(activity);
    }

    public static void removeAllActivity() {

        list.stream().filter(activity -> !activity.isFinishing()).forEach(Activity::finish);
    }

}
