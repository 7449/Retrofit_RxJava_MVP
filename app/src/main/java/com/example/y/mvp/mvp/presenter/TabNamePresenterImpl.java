package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.mvp.model.BaseDataBridge;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.TabNameModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class TabNamePresenterImpl extends BasePresenterImpl<BaseView.TabNameView>
        implements BasePresenter.TabNamePresenter, BaseDataBridge.TabNameData {

    private final BaseModel.TabNameModel tabNameModel;

    public TabNamePresenterImpl(BaseView.TabNameView view) {
        super(view);
        this.tabNameModel = new TabNameModelImpl();
    }


    @Override
    public void requestNetWork() {
        tabNameModel.netWork(this);
    }

    @Override
    public void addData(List<TabNameInfo> tabNameInfo) {
        view.setData(tabNameInfo);
    }

    @Override
    public void error() {
        view.netWorkError();
    }
}
