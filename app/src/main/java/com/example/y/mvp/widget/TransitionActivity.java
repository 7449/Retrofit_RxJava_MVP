package com.example.y.mvp.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.y.mvp.App;
import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.CacheUitls;

/**
 * by 12406 on 2016/7/16.
 */
public class TransitionActivity extends Activity {

    public static void startIntent() {
        ActivityUtils.startActivity(TransitionActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        ImageView imageView = (ImageView) findViewById(R.id.imageview);
        Bitmap bitmap = CacheUitls.getInstance().get(Constant.BITMAP_CACHE_KEY);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            startAnimation();
        }
    }


    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(1f).setDuration(200);
        animator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                App.getInstance().refreshAllActivity();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                finish();
                overridePendingTransition(0, android.R.anim.fade_out);
                CacheUitls.getInstance().remove(Constant.BITMAP_CACHE_KEY);
            }
        });
        animator.start();
    }

}
