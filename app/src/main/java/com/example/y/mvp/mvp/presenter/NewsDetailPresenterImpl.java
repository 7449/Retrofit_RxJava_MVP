package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.model.NewsDetailInfo;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.Network;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailPresenterImpl extends BasePresenterImpl<BaseView.NewsDetailView, NewsDetailInfo>
        implements Presenter.NewsDetailPresenter {


    public NewsDetailPresenterImpl(BaseView.NewsDetailView view) {
        super(view);
    }

    @Override
    protected void onNetWorkSuccess(NewsDetailInfo newsDetailInfo) {
        view.setData(newsDetailInfo);
        view.hideProgress();
    }

    @Override
    protected void onNetWorkError() {
        view.hideProgress();
        view.netWorkError();
    }

    @Override
    public void requestNetWork(int id) {
        view.showProgress();
        startNetWork(Network.getTngouApi().getNewsDetail(id));
    }

}
