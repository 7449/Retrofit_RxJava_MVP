package com.example.y.mvp.network;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.mvp.Bean.NewsDetailInfo;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/6.
 */
public class NetWorkRequest {


    @SuppressWarnings("unused")
    public static void newsDetail(int id, Subscriber<NewsDetailInfo> subscriber) {
        Network.getTngouApi().getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void newsList(int id, int page, Subscriber<BaseBean.NewsListBean> subscriber) {
        Network.getTngouApi().getNewsList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabNews(Subscriber<BaseBean.TabNewsBean> subscriber) {
        Network.getTngouApi().getTabNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageDetail(int id, Subscriber<BaseBean.ImageDetailBean> subscriber) {
        Network.getTngouApi().getImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageList(int id, int page, Subscriber<BaseBean.ImageListBean> subscriber) {
        Network.getTngouApi().getImageList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageNew(int id, int rows, Subscriber<BaseBean.ImageNewBean> subscriber) {
        Network.getTngouApi().getImageNews(id, rows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabName(Subscriber<BaseBean.TabNameBean> subscriber) {
        Network.getTngouApi().getTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
