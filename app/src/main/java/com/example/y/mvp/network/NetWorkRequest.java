package com.example.y.mvp.network;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.utils.RxUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/6.
 */
public class NetWorkRequest {


    public static void newsDetail(int id, Subscriber<NewsDetailInfo> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void newsList(int id, int page, Subscriber<BaseBean.NewsListBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getNewsList(id, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabNews(Subscriber<BaseBean.TabNewsBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getTabNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageDetail(int id, Subscriber<BaseBean.ImageDetailBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageList(int id, int page, Subscriber<BaseBean.ImageListBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getImageList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageNew(int id, int rows, Subscriber<BaseBean.ImageNewBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getImageNews(id, rows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabName(Subscriber<BaseBean.TabNameBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /////////////////////////////////////////////////////////////

    public static void jokeTextList(int page, Subscriber<JokeTextBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getBaiDuApi().getJokeText(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void jokePicList(int page, Subscriber<JokePicBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getBaiDuApi().getJokePic(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
