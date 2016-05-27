package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by 12406 on 2016/4/29.
 */
public class ImageNewModelImpl implements BaseModel.ImageNewModel {


    @Override
    public void netWorkNew(int id, int rows, final BaseDataBridge.ImageNewData imageNewData) {

        NetWorkRequest.imageNew(id, rows, new MySubscriber<BaseBean.ImageNewBean>() {
            @Override
            public void onError(Throwable e) {
                imageNewData.error();
            }

            @Override
            public void onNext(BaseBean.ImageNewBean imageNewBean) {
                imageNewData.addData(imageNewBean.getInfo());
            }
        });
    }

   
}
