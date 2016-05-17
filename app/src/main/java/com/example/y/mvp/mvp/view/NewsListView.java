package com.example.y.mvp.mvp.view;

import com.example.y.mvp.mvp.Bean.NewsListInfo;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
public interface NewsListView {

    void setNewsListInfo(List<NewsListInfo> newsListInfo);

    void netWorkError();

    void hideProgress();
    
    void showProgress();

    void showFoot();

    void hideFoot();
}
