package com.example.y.mvp.utils;


import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;

import com.example.y.mvp.R;


/**
 * by y on 2016/4/29.
 */
@SuppressWarnings("ALL")
public class DiaLogUtils {


    public static void iamgeViewDialog(final Activity activity, final ImageView imageView, final int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(UIUtils.getString(R.string.imageview_message));
        builder.setPositiveButton(UIUtils.getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                imageView.setDrawingCacheEnabled(true);
                Bitmap imageBitmap = imageView.getDrawingCache();
                if (imageBitmap != null) {
                    new SaveImageUtils(UIUtils.getActivity(), imageView, id).execute(imageBitmap);
                }
            }
        });
        builder.create().show();
    }

    public static void clearDialog(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        builder.setMessage(UIUtils.getString(R.string.clear_dialog_message));
        builder.setPositiveButton(UIUtils.getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }

}

