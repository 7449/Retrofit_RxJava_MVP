package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by y on 2016/5/30.
 */
public class JokePicModeImpl implements BaseModel.JokePicListModel {


    @Override
    public void netWorkJoke(int page, final BaseDataBridge.JokePicList jokeList) {
        NetWorkRequest.jokePicList(page, new MySubscriber<JokePicBean>() {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                jokeList.error();
            }

            @Override
            public void onNext(JokePicBean jokePicBean) {
                super.onNext(jokePicBean);
                jokeList.addData(jokePicBean.getShowapi_res_body().getContentlist());
            }
        });
    }
}
