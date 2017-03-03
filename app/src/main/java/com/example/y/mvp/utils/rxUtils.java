package com.example.y.mvp.utils;

import rx.Subscription;

public class RxUtils {
    public static Subscription subscription;

    public static void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
