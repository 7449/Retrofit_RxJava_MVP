package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;


/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsModelImpl implements BaseModel.TabNewsModel {


    @Override
    public void netWork(final BaseDataBridge.TabNewsData tabNewsData) {

        NetWorkRequest.tabNews(new MySubscriber<BaseBean.TabNewsBean>() {
            @Override
            public void onError(Throwable e) {
                tabNewsData.error();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.TabNewsBean tabNewsBean) {
                tabNewsData.addData(tabNewsBean.getInfo());
            }
        });


    }
}
