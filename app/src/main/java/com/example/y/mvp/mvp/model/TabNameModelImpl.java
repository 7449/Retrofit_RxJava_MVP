package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by y on 2016/4/28.
 */
public class TabNameModelImpl implements BaseModel.TabNameModel {


    @Override
    public void netWork(final BaseDataBridge.TabNameData tabNameData) {
        NetWorkRequest.tabName(new MySubscriber<BaseBean.TabNameBean>() {
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
