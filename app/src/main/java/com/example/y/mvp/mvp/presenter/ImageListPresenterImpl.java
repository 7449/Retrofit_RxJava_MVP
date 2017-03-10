package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.model.ImageListInfo;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.Network;

/**
 * by y on 2016/4/29.
 */
public class ImageListPresenterImpl extends BasePresenterImpl<BaseView.ImageListView, BaseBean.ImageListBean>
        implements Presenter.ImageListPresenter {


    public ImageListPresenterImpl(BaseView.ImageListView view) {
        super(view);
    }

    @Override
    public void requestNetWork(int id, int page) {
        if (page == 1) {
            view.hideFoot();
            view.showProgress();
        } else {
            view.showFoot();
        }
        startNetWork(Network.getTngouApi().getImageList(id, page));
    }

    @Override
    protected void onNetWorkSuccess(BaseBean.ImageListBean imageListBean) {
        view.setData(imageListBean.getTngou());
        view.hideFoot();
        view.hideProgress();
    }


    @Override
    protected void onNetWorkError() {
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();
    }

    @Override
    public void onClick(ImageListInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

}
