package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.Network;

/**
 * by y on 2016/4/29.
 */
public class TabNamePresenterImpl extends BasePresenterImpl<BaseView.TabNameView, BaseBean.TabNameBean>
        implements Presenter.TabNamePresenter {


    public TabNamePresenterImpl(BaseView.TabNameView view) {
        super(view);
    }

    @Override
    protected void onNetWorkSuccess(BaseBean.TabNameBean tabNameBean) {
        view.setData(tabNameBean.getTngou());
    }

    @Override
    protected void onNetWorkError() {
        view.netWorkError();
    }

    @Override
    public void requestNetWork() {
        startNetWork(Network.getTngouApi().getTabName());
    }
}
