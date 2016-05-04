package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.mvp.model.TabNameModel;
import com.example.y.mvp.mvp.model.TabNameModelImpl;
import com.example.y.mvp.mvp.view.TabNameView;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class TabNamePresenterImpl implements TabNamePresenter, TabNameModelImpl.TabNameData {

    private final TabNameView tabNameView;
    private final TabNameModel tabNameModel;

    public TabNamePresenterImpl(TabNameView tabNameView) {
        this.tabNameView = tabNameView;
        this.tabNameModel = new TabNameModelImpl();
    }


    @Override
    public void requestNetWork() {
        tabNameModel.netWorkName(this);
    }

    @Override
    public void addData(List<TabNameInfo> tabNameInfo) {
        tabNameView.addTabName(tabNameInfo);
    }

    @Override
    public void error() {
        tabNameView.netWorkError();
    }
}
