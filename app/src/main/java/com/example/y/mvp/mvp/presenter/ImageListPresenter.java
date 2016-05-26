package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.Bean.ImageListInfo;

/**
 * by y on 2016/4/29.
 */
public interface ImageListPresenter {


    void requestNetWork(int id, int page, boolean isNull);


    void onClick(ImageListInfo info);
}
