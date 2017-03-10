package com.example.y.mvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.y.mvp.utils.RxUtils;
import com.example.y.mvp.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * by y on 2016/7/25.
 */
public class App extends Application {

    private static Context context;
    private List<Activity> activityList = new ArrayList<>();

    public static Context getContext() {
        return context;
    }

    public static App getInstance() {
        return (App) context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SPUtils.init(this);
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public void exit() {
        activityList.forEach(Activity::finish);
        RxUtils.getInstance().clearSubscription();
    }

    public void refreshAllActivity() {
        activityList.forEach(Activity::recreate);
    }
}