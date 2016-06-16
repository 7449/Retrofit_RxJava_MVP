package com.example.y.mvp.utils.theme;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * by y on 2016/6/16.
 */
@SuppressWarnings("ALL")
public class ThemeUIUtils {

    /**
     * 切换应用主题
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void changeTheme(View rootView, Resources.Theme theme) {
        if (rootView instanceof ThemeUIInterface) {
            ((ThemeUIInterface) rootView).setTheme(theme);
            if (rootView instanceof ViewGroup) {
                int count = ((ViewGroup) rootView).getChildCount();
                for (int i = 0; i < count; i++) {
                    changeTheme(((ViewGroup) rootView).getChildAt(i), theme);
                }
            }
            if (rootView instanceof AbsListView) {
                try {
                    Field localField = AbsListView.class.getDeclaredField("mRecycler");
                    localField.setAccessible(true);
                    Method localMethod = Class.forName("android.widget.AbsListView$RecycleBin").getDeclaredMethod("clear");
                    localMethod.setAccessible(true);
                    localMethod.invoke(localField.get(rootView));
                } catch (NoSuchFieldException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            if (rootView instanceof ViewGroup) {
                int count = ((ViewGroup) rootView).getChildCount();
                for (int i = 0; i < count; i++) {
                    changeTheme(((ViewGroup) rootView).getChildAt(i), theme);
                }
            }
            if (rootView instanceof AbsListView) {
                try {
                    Field localField = AbsListView.class.getDeclaredField("mRecycler");
                    localField.setAccessible(true);
                    Method localMethod = Class.forName("android.widget.AbsListView$RecycleBin").getDeclaredMethod("clear");
                    localMethod.setAccessible(true);
                    localMethod.invoke(localField.get(rootView));
                } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
