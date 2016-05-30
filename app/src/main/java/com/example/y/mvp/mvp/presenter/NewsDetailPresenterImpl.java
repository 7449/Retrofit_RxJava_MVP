package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.mvp.model.BaseDataBridge;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.NewsDetailModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailPresenterImpl extends BasePresenterImpl<BaseView.NewsDetailView>
        implements BasePresenter.NewsDetailPresenter, BaseDataBridge.NewsDetailData {

    private final BaseModel.NewsDetailModel newsDetailModel;

    public NewsDetailPresenterImpl(BaseView.NewsDetailView view) {
        super(view);
        newsDetailModel = new NewsDetailModelImpl();
    }

    @Override
    public void requestNetWork(int id) {
        view.showProgress();
        newsDetailModel.netWorkNewsDetail(id, this);
    }

    @Override
    public void addData(NewsDetailInfo datas) {
        view.setData(datas);
        view.hideProgress();
    }


    @Override
    public void error() {
        view.hideProgress();
        view.netWorkError();
    }
}
