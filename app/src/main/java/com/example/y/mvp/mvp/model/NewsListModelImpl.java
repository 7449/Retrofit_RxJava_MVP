package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.NewsListBean;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListModelImpl implements NewsListModel {


    @Override
    public void netWorkNewList(int id, int page, final NewsListData newsListData) {

        NetWorkRequest.newsList(id, page, new MySubscriber<NewsListBean>() {

            @Override
            public void onError(Throwable e) {
                newsListData.error();
            }

            @Override
            public void onNext(NewsListBean newsListBean) {
                newsListData.addData(newsListBean.getTngou());
            }

        });
    }

    public interface NewsListData {

        void addData(List<NewsListInfo> tngou);

        void error();
    }
}
