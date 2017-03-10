package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.network.NetWorkSubscriber;
import com.example.y.mvp.utils.RxUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/27.
 */
public abstract class BasePresenterImpl<V, M> {

    protected final V view;

    BasePresenterImpl(V view) {
        this.view = view;
    }

    void startNetWork(Observable<M> observable) {
        RxUtils.getInstance().addSubscription(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetWorkSubscriber<M>() {

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        onNetWorkError();
                    }

                    @Override
                    public void onNext(M m) {
                        super.onNext(m);
                        onNetWorkSuccess(m);
                    }
                }));
    }

    protected abstract void onNetWorkSuccess(M m);

    protected abstract void onNetWorkError();
}
