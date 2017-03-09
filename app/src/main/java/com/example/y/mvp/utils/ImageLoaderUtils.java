package com.example.y.mvp.utils;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.y.mvp.R;

/**
 * by y on 2016/4/29.
 */

public class ImageLoaderUtils {

    public static void display(@NonNull ImageView imageView, @NonNull String url, int placeholder, int error) {
        Glide.with(imageView.getContext()).load(url).placeholder(placeholder)
                .error(error).crossFade().into(imageView);
    }

    public static void display(@NonNull ImageView imageView, @NonNull String url) {
        Glide.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).crossFade().into(imageView);
    }
}
