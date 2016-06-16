package com.example.y.mvp.network;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * by y on 2016/6/16.
 * 单例模式
 * 可以参考这篇博文：http://www.race604.com/java-double-checked-singleton/
 */
public class RxBus {

    private final Subject rxBus;

    private RxBus() {
        rxBus = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getInstance() {
        return rxbusHolder.instance;
    }

    public static class rxbusHolder {
        private static final RxBus instance = new RxBus();
    }

    public void send(Object object) {
        rxBus.onNext(object);
    }

//    public Observable<Object> toObserverable() {
//        return rxBus;
//    }

    public <T> Observable<T> toObserverable(final Class<T> eventType) {
        return rxBus.filter(new Func1<Object, Boolean>() {
            @Override
            public Boolean call(Object object) {
                return eventType.isInstance(object);
            }
        }).cast(eventType);
    }

}
