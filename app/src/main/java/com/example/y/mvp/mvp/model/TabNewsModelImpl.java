package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.NetWorkSubscriber;


/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsModelImpl implements BaseModel.TabNewsModel {


    @Override
    public void netWork(final BaseDataBridge.TabNewsData tabNewsData) {

        NetWorkRequest.tabNews(new NetWorkSubscriber<BaseBean.TabNewsBean>() {
            @Override
            public void onError(Throwable e) {
                tabNewsData.error();
            }


            @Override
            public void onNext(BaseBean.TabNewsBean tabNewsBean) {
                tabNewsData.addData(tabNewsBean.getInfo());
            }
        });


    }
}
