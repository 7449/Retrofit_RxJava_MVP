package com.example.y.mvp.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.y.mvp.utils.ActivityCollector;
import com.example.y.mvp.utils.LogUtils;
import com.example.y.mvp.utils.RxUtils;

import butterknife.ButterKnife;

/**
 * by y on 2016/4/28.
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        LogUtils.i("BaseActivity", getClass().getSimpleName());
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
    }

    protected void Toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
        RxUtils.getInstance().unSubscription();
    }
}
