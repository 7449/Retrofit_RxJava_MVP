package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.NetWorkSubscriber;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListModelImpl implements BaseModel.NewsListModel {


    @Override
    public void netWorkNewList(int id, int page, final BaseDataBridge.NewsListData newsListData) {

        NetWorkRequest.newsList(id, page, new NetWorkSubscriber<BaseBean.NewsListBean>() {

            @Override
            public void onError(Throwable e) {
                newsListData.error();
            }


            @Override
            public void onNext(BaseBean.NewsListBean newsListBean) {
                newsListData.addData(newsListBean.getInfo());
            }
        });
    }


}
