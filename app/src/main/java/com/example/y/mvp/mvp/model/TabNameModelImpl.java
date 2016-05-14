package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.TabNameBean;
import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

import java.util.List;

/**
 * by y on 2016/4/28.
 */
public class TabNameModelImpl implements TabNameModel {


    @Override
    public void netWorkName(final TabNameData tabNameData) {
        NetWorkRequest.tabName(new MySubscriber<TabNameBean>() {
            @Override
            public void onError(Throwable e) {
                tabNameData.error();
            }

            @Override
            public void onNext(TabNameBean tabNameBean) {
                tabNameData.addData(tabNameBean.getTngou());
            }
        });
    }


    public interface TabNameData {

        void addData(List<TabNameInfo> tabNameInfo);

        void error();
    }

}
