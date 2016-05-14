package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.ImageListBean;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

import java.util.List;

/**
 * by y on 2016/4/28.
 */
public class ImageListModelImpl implements ImageListModel {

    @Override
    public void netWorkList(int id, final int page, final ImageListData imageListData) {

        NetWorkRequest.imageList(id, page, new MySubscriber<ImageListBean>() {
            @Override
            public void onError(Throwable e) {
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
