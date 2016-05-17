package com.example.y.mvp.utils;

import rx.Subscription;

/**
 * by y on 2016/5/17.
 */
@SuppressWarnings("ALL")
public class RxUtils {

    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
