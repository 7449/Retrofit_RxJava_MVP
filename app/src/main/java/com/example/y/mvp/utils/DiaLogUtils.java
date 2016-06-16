package com.example.y.mvp.utils;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;

import com.example.y.mvp.R;


/**
 * by y on 2016/4/29.
 */
public class DiaLogUtils {


    public static void iamgeViewDialog(final ImageView imageView, final int id) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(UIUtils.getActivity());
        builder.setMessage(UIUtils.getString(R.string.imageview_message));
        builder.setPositiveButton(UIUtils.getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                imageView.setDrawingCacheEnabled(true);
                SaveImageUtils.imageSave(imageView, id);
            }
        });
        builder.create().show();
    }


}

