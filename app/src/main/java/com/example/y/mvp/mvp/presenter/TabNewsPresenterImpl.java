package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.TabNewsInfo;
import com.example.y.mvp.mvp.model.BaseDataBridge;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.TabNewsModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsPresenterImpl extends BasePresenterImpl<BaseView.TabNewsView>
        implements BasePresenter.TabNewsPresenter, BaseDataBridge.TabNewsData {


    private final BaseModel.TabNewsModel tabNewsModel;

    public TabNewsPresenterImpl(BaseView.TabNewsView view) {
        super(view);
        this.tabNewsModel = new TabNewsModelImpl();
    }


    @Override
    public void requestNetWork() {
        tabNewsModel.netWork(this);
    }

    @Override
    public void addData(List<TabNewsInfo> newsInfo) {
        view.setData(newsInfo);
    }

    @Override
    public void error() {
        view.netWorkError();
    }
}
