package com.example.y.mvp.utils.theme;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.example.y.mvp.data.Constant;

/**
 * SharedPreferences管理类
 */
@SuppressWarnings("ALL")
public class SharedPreferencesMgr {

    private static SharedPreferences sharedPreferences;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private static void initSharePreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("derson", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
    }

    public static void init(Context context) {
        initSharePreferences(context);
    }

    public static String fileName;

    public static int getInt() {
        return sharedPreferences.getInt(Constant.THEME, 0);
    }

    public static void setInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static void setBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public static String getString(String key, String defaultValue) {
        if (sharedPreferences == null) {
            return defaultValue;
        }
        return sharedPreferences.getString(key, defaultValue);
    }

    public static void setString(String key, String value) {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(key, value).apply();
    }

    public static void clearAll() {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    public static boolean getIsNight() {
        return sharedPreferences.getBoolean(Constant.IS_NIGHT, true);
    }

    public static void setIsNight(boolean value) {
        sharedPreferences.edit().putBoolean(Constant.IS_NIGHT, value).apply();
    }


}
