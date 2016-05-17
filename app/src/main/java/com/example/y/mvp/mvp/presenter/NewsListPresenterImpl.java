package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.mvp.model.NewsListModel;
import com.example.y.mvp.mvp.model.NewsListModelImpl;
import com.example.y.mvp.mvp.view.NewsListView;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListPresenterImpl implements NewsListPresenter, NewsListModelImpl.NewsListData {

    private final NewsListModel newsListModel;
    private final NewsListView newsListView;

    public NewsListPresenterImpl(NewsListView newsListView) {
        this.newsListView = newsListView;
        this.newsListModel = new NewsListModelImpl();
    }

    @Override
    public void requestNetWork(int id, int page) {
        if (page == 1) {
            newsListView.showProgress();
        } else {
            newsListView.showFoot();
        }
        newsListModel.netWorkNewList(id, page, this);
    }

    @Override
    public void onClick(NewsListInfo info) {

    }

    @Override
    public void addData(List<NewsListInfo> tngou) {
        if (!tngou.isEmpty()) {
            newsListView.setNewsListInfo(tngou);
        }
        newsListView.hideFoot();
        newsListView.hideProgress();
    }

    @Override
    public void error() {
        newsListView.hideFoot();
        newsListView.hideProgress();
        newsListView.netWorkError();
    }
}
