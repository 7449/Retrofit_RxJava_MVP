package com.example.y.mvp.utils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * by y on 2017/3/8
 */

public class RxUtils {

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    private RxUtils() {
    }

    private static final class RxUtilsHolder {
        private static final RxUtils RX_UTILS = new RxUtils();
    }

    public static RxUtils getInstance() {
        return RxUtilsHolder.RX_UTILS;
    }

    public void clearSubscription() {
        if (compositeSubscription != null && !compositeSubscription.isUnsubscribed()) {
            compositeSubscription.clear();
        }
    }

    public void unSubscription() {
        if (compositeSubscription != null && !compositeSubscription.isUnsubscribed()) {
            compositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription subscription) {
        if (compositeSubscription != null) {
            compositeSubscription.add(subscription);
        }
    }

}
