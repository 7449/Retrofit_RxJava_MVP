package com.example.y.mvp.mvp.presenter;

/**
 * by y on 2016/5/27.
 */
@SuppressWarnings("ALL")
public class BasePresenterImpl<T> {

    T view;

    public BasePresenterImpl(T view) {
        this.view = view;
    }

}
