package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.Bean.ImageNewInfo;

/**
 * by y on 2016/4/29.
 */
public interface ImageNewPresenter {


    void requestNetWork(int id, int rows);

    void onClick(ImageNewInfo info);


}
