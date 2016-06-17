package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.mvp.model.BaseDataBridge;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.ImageListModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageListPresenterImpl extends BasePresenterImpl<BaseView.ImageListView>
        implements BasePresenter.ImageListPresenter, BaseDataBridge.ImageListData {

    private final BaseModel.ImageListModel imageListModel;

    public ImageListPresenterImpl(BaseView.ImageListView view) {
        super(view);
        this.imageListModel = new ImageListModelImpl();
    }

    @Override
    public void requestNetWork(int id, int page, boolean isNull) {
        if (page == 1) {
            view.showProgress();
        } else {
            if (!isNull) {
                view.showFoot();
            }
        }
        imageListModel.netWorkList(id, page, this);
    }


    @Override
    public void onClick(ImageListInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }


    @Override
    public void addData(List<ImageListInfo> imageListInfo) {
        view.setData(imageListInfo);
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
