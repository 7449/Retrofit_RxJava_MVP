package com.example.y.mvp.utils;


import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.network.NetWorkSubscriber;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by 12406 on 2016/4/30.
 */

public class SaveImageUtils {


    public static void imageSave(final ImageView imageView, final int id) {
        Observable
                .create(new Observable.OnSubscribe<ImageView>() {
                            @Override
                            public void call(Subscriber<? super ImageView> sub) {
                                sub.onNext(imageView);
                                RxUtils.getInstance().addSubscription(sub);
                            }

                        }
                ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetWorkSubscriber<ImageView>() {
                    @Override
                    public void onNext(ImageView imageView) {
                        File imageFile = new File(ActivityUtils.ImagePath(), id + ".jpg");
                        FileOutputStream outStream;
                        try {
                            outStream = new FileOutputStream(imageFile);
                            Bitmap image = imageView.getDrawingCache();
                            image.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                            outStream.flush();
                            outStream.close();
                            Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.save_picture_success), Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                            onError(e);
                        }
                        RxUtils.getInstance().unSubscription();
                    }

                    @Override
                    public void onError(Throwable e) {
                        RxUtils.getInstance().unSubscription();
                        Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.save_picture_failed), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
