package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.NetWorkSubscriber;

/**
 * by y on 2016/4/28.
 */
public class ImageListModelImpl implements BaseModel.ImageListModel {

    @Override
    public void netWorkList(int id, final int page, final BaseDataBridge.ImageListData imageListData) {

        NetWorkRequest.imageList(id, page, new NetWorkSubscriber<BaseBean.ImageListBean>() {
            @Override
            public void onError(Throwable e) {
                imageListData.error();
            }


            @Override
            public void onNext(BaseBean.ImageListBean imageListBean) {
                imageListData.addData(imageListBean.getInfo());
            }
        });
    }


}
