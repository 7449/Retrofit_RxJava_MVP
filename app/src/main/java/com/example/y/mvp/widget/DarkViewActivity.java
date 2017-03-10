package com.example.y.mvp.widget;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.utils.SPUtils;

/**
 * by 12406 on 2016/7/15.
 */
public abstract class DarkViewActivity extends BaseActivity {

    private WindowManager windowManager = null;
    private View darkView = null;
    private boolean isAddedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isAddedView = false;
        if (!SPUtils.isTheme(Constant.DAY)) {
            initNightView();
            darkView.setBackgroundResource(R.color.night_mask);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isAddedView) {
            windowManager.removeViewImmediate(darkView);
            windowManager = null;
            darkView = null;
        }
    }


    protected void initNightView() {
        if (isAddedView) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);
        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        darkView = new View(this);
        windowManager.addView(darkView, layoutParams);
        isAddedView = true;
    }
}
