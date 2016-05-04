package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.ImageListBean;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.network.Network;
import com.example.y.mvp.utils.LogUtils;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/4/28.
 */
public class ImageListModelImpl implements ImageListModel {

    @Override
    public void netWorkList(int id, final int page, final ImageListData imageListData) {
        Network.getImageListApi().getImageList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i("ImageListModelImpl:-->", e.getMessage());
                        imageListData.error();
                    }

                    @Override
                    public void onNext(ImageListBean imageListBean) {
                        imageListData.addData(imageListBean.getTngou());
                    }
                });
    }

    public interface ImageListData {

        void addData(List<ImageListInfo> imageListInfo);

        void error();
    }
}
