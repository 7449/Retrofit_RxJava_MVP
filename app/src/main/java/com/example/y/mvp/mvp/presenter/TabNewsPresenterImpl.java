package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.TabNewsInfo;
import com.example.y.mvp.mvp.model.TabNewsModel;
import com.example.y.mvp.mvp.model.TabNewsModelImpl;
import com.example.y.mvp.mvp.view.TabNewsView;

import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsPresenterImpl implements TabNewsPresenter, TabNewsModelImpl.TabNewsData {


    private final TabNewsView tabNewsView;
    private final TabNewsModel tabNewsModel;


    public TabNewsPresenterImpl(TabNewsView tabNewsView) {
        this.tabNewsView = tabNewsView;
        this.tabNewsModel = new TabNewsModelImpl();
    }


    @Override
    public void requestNetWork() {
        tabNewsModel.netWorkName(this);
    }

    @Override
    public void addData(List<TabNewsInfo> newsInfo) {
        if (!newsInfo.isEmpty()){
            tabNewsView.addTabName(newsInfo);
        }
    }

    @Override
    public void error() {
        tabNewsView.netWorkError();
    }
}
