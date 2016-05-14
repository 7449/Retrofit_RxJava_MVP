package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.TabNewsBean;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

import java.util.List;


/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsModelImpl implements TabNewsModel {


    @Override
    public void netWorkName(final TabNewsData tabNewsData) {

        NetWorkRequest.tabNews(new MySubscriber<TabNewsBean>() {
            @Override
            public void onError(Throwable e) {
                tabNewsData.error();
            }

            @Override
            public void onNext(TabNewsBean tabNewsBean) {
                tabNewsData.addData(tabNewsBean.getNewsInfo());
            }
        });


    }

    public interface TabNewsData {


        void addData(List<TabNewsInfo> newsInfo);

        void error();
    }
}
