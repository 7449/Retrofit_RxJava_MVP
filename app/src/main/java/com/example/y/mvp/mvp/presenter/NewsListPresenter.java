package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.NewsListInfo;

/**
 * by 12406 on 2016/5/15.
 */
@SuppressWarnings("ALL")
public interface NewsListPresenter {


    void requestNetWork(int id, int page, boolean isNull);


    void onClick(NewsListInfo info);


}
