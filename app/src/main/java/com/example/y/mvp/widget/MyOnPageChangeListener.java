package com.example.y.mvp.widget;

import android.support.v4.view.ViewPager;

import com.example.y.mvp.utils.LogUtils;

/**
 * by y on 2016/6/12.
 */
public class MyOnPageChangeListener
        implements ViewPager.OnPageChangeListener {

    private static final String TAG = "MyOnPageChangeListener";

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        LogUtils.i(TAG, "滑动到了" + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
