package com.example.y.mvp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.utils.ActivityCollector;
import com.example.y.mvp.utils.LogUtils;
import com.example.y.mvp.utils.theme.SharedPreferencesMgr;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * by y on 2016/4/28.
 */
@SuppressWarnings("ALL")
public abstract class BaseActivity extends AppCompatActivity {

    private static Context context;
    private static Activity activity;
    protected Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initWindow();
        context = getApplicationContext();
        activity = this;
        SharedPreferencesMgr.init(context);
        if (SharedPreferencesMgr.getInt() == 1) {
            setTheme(R.style.theme_2);
        } else {
            setTheme(R.style.theme_1);
        }
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        LogUtils.i("BaseActivity", getClass().getSimpleName());

        ActivityCollector.addActivity(this);
    }

    private void initWindow() {
//         默认全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
//         不全屏显示
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
//         全屏显示
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    }

    //隐藏状态栏
    void hideStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }

    //显示状态栏
    void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }

    void Toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }


    public static Context getContext() {
        return context;
    }

    public static Activity getActivity() {
        return activity;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected abstract int getLayoutId();


}
