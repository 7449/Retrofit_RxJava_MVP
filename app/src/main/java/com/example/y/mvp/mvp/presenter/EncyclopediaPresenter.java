package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.EncyclopediaInfo;

/**
 * by y on 2016/5/11.
 */
public interface EncyclopediaPresenter {


    void requestNetWork(String keyword, int page);

    void onClick(EncyclopediaInfo info);
}
