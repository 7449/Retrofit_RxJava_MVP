package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailModelImpl implements BaseModel.NewsDetailModel {

    @Override
    public void netWorkNewsDetail(int id, final BaseDataBridge.NewsDetailData newsDetailData) {

        NetWorkRequest.newsDetail(id, new MySubscriber<NewsDetailInfo>() {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                newsDetailData.error();
            }

            @Override
            public void onNext(NewsDetailInfo newsDetailInfo) {
                super.onNext(newsDetailInfo);
                newsDetailData.addData(newsDetailInfo);
            }
        });


    }
}
