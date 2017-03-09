package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.NetWorkSubscriber;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailModelImpl implements BaseModel.ImageDetailModel {


    @Override
    public void netWorkDetail(int id, final BaseDataBridge.ImageDetailData imageDetailData) {

        NetWorkRequest.imageDetail(id, new NetWorkSubscriber<BaseBean.ImageDetailBean>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                imageDetailData.error();
            }


            @Override
            public void onNext(BaseBean.ImageDetailBean imageDetailBean) {
                super.onNext(imageDetailBean);
                imageDetailData.addData(imageDetailBean.getList());
            }
        });
    }


}
