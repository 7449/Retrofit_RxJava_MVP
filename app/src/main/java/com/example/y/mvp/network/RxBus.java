package com.example.y.mvp.network;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * by y on 2016/6/16.
 * 单例模式
 * 可以参考这篇博文：http://www.race604.com/java-double-checked-singleton/
 */
public class RxBus {

    private Subject rxBus;

    private RxBus() {
        rxBus = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getInstance() {
        return RxbusHolder.rxBus;
    }

    public void sendNetWork(Object object) {
        rxBus.onNext(object);
    }

    public <T> Observable<T> toObserverable(final Class<T> eventType) {
        return rxBus.ofType(eventType);
    }

    public static class RxbusHolder {
        private static final RxBus rxBus = new RxBus();
    }

}
