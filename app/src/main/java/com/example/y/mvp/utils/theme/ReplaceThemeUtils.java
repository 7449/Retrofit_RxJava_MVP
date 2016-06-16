package com.example.y.mvp.utils.theme;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.data.IsNightMode;
import com.example.y.mvp.network.RxBus;
import com.example.y.mvp.utils.LogUtils;
import com.example.y.mvp.utils.UIUtils;

/**
 * by y on 2016/6/16.
 */
public class ReplaceThemeUtils {


    public static void theme() {

        LogUtils.i("colorUIUtils", "开始更换主题");

        if (SharedPreferencesMgr.getInt() == 1) {

            SharedPreferencesMgr.setInt(Constant.THEME, 0);
            UIUtils.getActivity().setTheme(R.style.theme_1);

            RxBus.getInstance().send(new IsNightMode(true));

            SharedPreferencesMgr.setIsNight(true);


            LogUtils.i("colorUIUtils", "白天");
        } else {

            SharedPreferencesMgr.setInt(Constant.THEME, 1);
            UIUtils.getActivity().setTheme(R.style.theme_2);

            RxBus.getInstance().send(new IsNightMode(false));

            SharedPreferencesMgr.setIsNight(false);


            LogUtils.i("colorUIUtils", "夜晚");
        }
        final View rootView = UIUtils.getActivity().getWindow().getDecorView();
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache(true);
        final Bitmap localBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        if (null != localBitmap && rootView instanceof ViewGroup) {
            final View localView2 = new View(UIUtils.getContext());
            //noinspection deprecation
            localView2.setBackgroundDrawable(new BitmapDrawable(UIUtils.getContext().getResources(), localBitmap));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) rootView).addView(localView2, params);
            localView2.animate().alpha(0).setDuration(400).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    ThemeUIUtils.changeTheme(rootView, UIUtils.getActivity().getTheme());
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ((ViewGroup) rootView).removeView(localView2);
                    localBitmap.recycle();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            }).start();
        } else {
            ThemeUIUtils.changeTheme(rootView, UIUtils.getActivity().getTheme());
        }
    }
}
