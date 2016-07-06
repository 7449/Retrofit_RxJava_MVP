package com.example.y.mvp.utils;

import rx.Subscription;

/**
 * by y on 2016/7/6.
 */
public class RxUtils {

    public static Subscription subscription;

    public static void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
