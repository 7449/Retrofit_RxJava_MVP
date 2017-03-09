package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.NetWorkSubscriber;

/**
 * by y on 2016/4/28.
 */
public class TabNameModelImpl implements BaseModel.TabNameModel {


    @Override
    public void netWork(final BaseDataBridge.TabNameData tabNameData) {
        NetWorkRequest.tabName(new NetWorkSubscriber<BaseBean.TabNameBean>() {
            @Override
            public void onError(Throwable e) {
                tabNameData.error();
            }


            @Override
            public void onNext(BaseBean.TabNameBean tabNameBean) {
                tabNameData.addData(tabNameBean.getInfo());
            }
        });
    }


}
