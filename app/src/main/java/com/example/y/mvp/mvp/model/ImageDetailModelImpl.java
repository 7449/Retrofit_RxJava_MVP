package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.ImageDetailBean;
import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.network.Network;
import com.example.y.mvp.utils.LogUtils;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailModelImpl implements ImageDetailModel {


    @Override
    public void netWorkDetail(int id, final ImageDetailData imageDetailData) {

        Network.getImageDetailApi().getImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageDetailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i("ImageDetailModelImpl:-->", e.getMessage());
                        imageDetailData.error();
                    }

                    @Override
                    public void onNext(ImageDetailBean imageDetailBean) {
                        imageDetailData.addData(imageDetailBean.getList());
                    }
                });
    }


    public interface ImageDetailData {

        void addData(List<ImageDetailInfo> imageDetailInfo);

        void error();
    }
}
