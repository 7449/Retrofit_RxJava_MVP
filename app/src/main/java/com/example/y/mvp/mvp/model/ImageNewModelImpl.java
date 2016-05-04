package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.ImageNewBean;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.network.Network;
import com.example.y.mvp.utils.LogUtils;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by 12406 on 2016/4/29.
 */
public class ImageNewModelImpl implements ImageNewModel {


    @Override
    public void netWorkNew(int id, int rows, final ImageNewData imageNewData) {
        Network.getImageNewApi().getImageNews(id, rows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageNewBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i("ImageNewModelImpl", e.getMessage());
                        imageNewData.error();
                    }

                    @Override
                    public void onNext(ImageNewBean imageNewBean) {
                        imageNewData.addData(imageNewBean.getTngou());
                        LogUtils.i("imagenewBean_size", imageNewBean.getTngou().size() + "");
                    }
                });
    }

    public interface ImageNewData {

        void addData(List<ImageNewInfo> imageNewInfo);

        void error();
    }
}
