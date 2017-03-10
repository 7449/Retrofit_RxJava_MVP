package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.activity.NewsDetailActivity;
import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.model.NewsListInfo;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.Network;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListPresenterImpl extends BasePresenterImpl<BaseView.NewsListView, BaseBean.NewsListBean>
        implements Presenter.NewsListPresenter {


    public NewsListPresenterImpl(BaseView.NewsListView view) {
        super(view);
    }

    @Override
    protected void onNetWorkSuccess(BaseBean.NewsListBean newsListBean) {
        view.setData(newsListBean.getTngou());
        view.hideFoot();
        view.hideProgress();
    }

    @Override
    public void requestNetWork(final int id, final int page) {
        if (page == 1) {
            view.hideFoot();
            view.showProgress();
        } else {
            view.showFoot();
        }
        startNetWork(Network.getTngouApi().getNewsList(id, page));
    }


    @Override
    protected void onNetWorkError() {
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();
    }

    @Override
    public void onClick(NewsListInfo info) {
        NewsDetailActivity.startIntent(info.getId());
    }

}
