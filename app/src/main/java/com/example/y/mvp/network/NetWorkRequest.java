package com.example.y.mvp.network;

import com.example.y.mvp.mvp.Bean.ImageDetailBean;
import com.example.y.mvp.mvp.Bean.ImageListBean;
import com.example.y.mvp.mvp.Bean.ImageNewBean;
import com.example.y.mvp.mvp.Bean.TabNameBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/6.
 */
public class NetWorkRequest {


    public static void imageDetail(int id, Subscriber<ImageDetailBean> subscriber) {
        Network.getImageDetailApi().getImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageList(int id, int page, Subscriber<ImageListBean> subscriber) {
        Network.getImageListApi().getImageList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageNew(int id, int rows, Subscriber<ImageNewBean> subscriber) {
        Network.getImageNewApi().getImageNews(id, rows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabName(Subscriber<TabNameBean> subscriber) {
        Network.getTabNameApi().getTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    
    
}
