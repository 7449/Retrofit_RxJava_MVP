package com.example.y.mvp.utils;


import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.y.mvp.R;

import java.io.File;
import java.io.FileOutputStream;

/**
 * by 12406 on 2016/4/30.
 */
@SuppressWarnings("ALL")
public class SaveImageUtils extends AsyncTask<Bitmap, Void, String> {

    Activity mActivity;
    ImageView mImageView;
    int id;

    public SaveImageUtils(Activity activity, ImageView imageView, int id) {
        this.mImageView = imageView;
        this.mActivity = activity;
        this.id = id;
    }

    @Override
    protected String doInBackground(Bitmap... params) {
        String result = mActivity.getResources().getString(R.string.save_picture_failed);
        try {
            String sdcard = Environment.getExternalStorageDirectory().toString();
//            String sd = mActivity.getExternalFilesDir(Environment.DIRECTORY_DCIM).getPath() + File.separator + mActivity.getPackageName();
            File file = new File(sdcard + "/DCIM");
            if (!file.exists()) {
                file.mkdirs();
            }
            File mFile = new File(file + "/Demo");
            if (!mFile.exists()) {
                mFile.mkdirs();
            }
            File imageFile = new File(mFile.getAbsolutePath(), id + ".jpg");
            FileOutputStream outStream = new FileOutputStream(imageFile);
            Bitmap image = params[0];
            image.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();
            result = mActivity.getResources().getString(R.string.save_picture_success, mFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(mActivity, result, Toast.LENGTH_SHORT).show();
        mImageView.setDrawingCacheEnabled(false);
    }
}
