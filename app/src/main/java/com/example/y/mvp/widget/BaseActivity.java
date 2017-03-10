package com.example.y.mvp.widget;

import android.os.Bundle;
import android.view.View;

import com.backlayout.SwipeBackActivity;
import com.backlayout.SwipeBackLayout;
import com.example.y.mvp.App;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.utils.RxUtils;
import com.example.y.mvp.utils.SPUtils;

/**
 * by y on 2016/4/28.
 */
public abstract class BaseActivity extends SwipeBackActivity {

    protected SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(SPUtils.isTheme(Constant.DAY) ? Constant.DAY_STYLES : Constant.NIGHT_STYLES);
        setContentView(getLayoutId());
        initById();
        swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initCreate(savedInstanceState);
        App.getInstance().addActivity(this);
    }

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    protected abstract void initCreate(Bundle savedInstanceState);

    protected abstract void initById();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        RxUtils.getInstance().unSubscription();
    }
}
