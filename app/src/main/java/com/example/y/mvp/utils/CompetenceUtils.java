package com.example.y.mvp.utils;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.y.mvp.data.Constant;

/**
 * by y on 2016/5/4.
 */
public class CompetenceUtils {


    //存储权限

    public static void Storage() {
        if (ContextCompat.checkSelfPermission(UIUtils.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(UIUtils.getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
        }
    }

}
