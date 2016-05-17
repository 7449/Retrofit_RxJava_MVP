package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.mvp.model.ImageListModel;
import com.example.y.mvp.mvp.model.ImageListModelImpl;
import com.example.y.mvp.mvp.view.ImageListView;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageListPresenterImpl implements ImageListPresenter, ImageListModelImpl.ImageListData {

    private final ImageListView imageListView;
    private final ImageListModel imageListModel;

    public ImageListPresenterImpl(ImageListView imageListView) {
        this.imageListView = imageListView;
        this.imageListModel = new ImageListModelImpl();
    }

    @Override
    public void requestNetWork(int id, int page) {
        if (page == 1) {
            imageListView.showProgress();
        } else {
            imageListView.showFoot();
        }
        imageListModel.netWorkList(id, page, this);
    }


    @Override
    public void onClick(ImageListInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }


    @Override
    public void addData(List<ImageListInfo> imageListInfo) {
        if (!imageListInfo.isEmpty()) {
            imageListView.setImageListInfo(imageListInfo);
        }
        imageListView.hideFoot();
        imageListView.hideProgress();
    }

    @Override
    public void error() {
        imageListView.hideFoot();
        imageListView.hideProgress();
        imageListView.netWorkError();
    }
}
