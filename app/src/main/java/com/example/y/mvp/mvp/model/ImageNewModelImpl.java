package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.ImageNewBean;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.utils.LogUtils;

import java.util.List;

/**
 * by 12406 on 2016/4/29.
 */
public class ImageNewModelImpl implements ImageNewModel {


    @Override
    public void netWorkNew(int id, int rows, final ImageNewData imageNewData) {

        NetWorkRequest.imageNew(id, rows, new MySubscriber<ImageNewBean>() {
            @Override
            public void onError(Throwable e) {
                LogUtils.i("ImageNewModelImpl", e.getMessage());
                imageNewData.error();
            }

            @Override
            public void onNext(ImageNewBean imageNewBean) {
                imageNewData.addData(imageNewBean.getTngou());
            }
        });
    }

    public interface ImageNewData {

        void addData(List<ImageNewInfo> imageNewInfo);

        void error();
    }
}
