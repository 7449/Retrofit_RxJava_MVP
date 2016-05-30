package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.mvp.model.BaseDataBridge;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.JokePicModeImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class JokePicPresenterImpl extends BasePresenterImpl<BaseView.JokePicView>
        implements BasePresenter.JokePicPresenter, BaseDataBridge.JokePicList {

    private final BaseModel.JokePicListModel jokePicListModel;


    public JokePicPresenterImpl(BaseView.JokePicView view) {
        super(view);
        jokePicListModel = new JokePicModeImpl();
    }

    @Override
    public void requestNetWork(int page, boolean isNull) {
        if (page == 1) {
            view.showProgress();
        } else {
            if (!isNull) {
                view.showFoot();
            }
        }
        jokePicListModel.netWorkJoke(page, this);
    }

    @Override
    public void addData(List<JokePicBean.JokePicInfo> datas) {
        view.setData(datas);
        view.hideFoot();
        view.hideProgress();
    }

    @Override
    public void error() {
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();
    }
}
