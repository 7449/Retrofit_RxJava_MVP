package com.example.y.mvp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * by 12406 on 2016/4/29.
 */
@SuppressWarnings("ALL")
public class NetWorkUtils {


    public static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        return !(activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI);
    }
}
