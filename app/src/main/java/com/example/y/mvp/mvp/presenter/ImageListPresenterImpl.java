package com.example.y.mvp.mvp.presenter;


import android.os.Bundle;

import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.mvp.model.ImageListModel;
import com.example.y.mvp.mvp.model.ImageListModelImpl;
import com.example.y.mvp.mvp.view.ImageListView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.LogUtils;

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
        if (page != 1) {
            imageListView.showFoot();
        }
        imageListModel.netWorkList(id, page, this);
    }


    @Override
    public void onClick(ImageListInfo info) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", info.getId());
        bundle.putString("title", info.getTitle());
        ActivityUtils.startActivity(ImageDetailActivity.class, bundle);
    }


    @Override
    public void addData(List<ImageListInfo> imageListInfo) {
        if (imageListInfo.size() == 0) {
            imageListView.hideFoot();
        }
        imageListView.setImageListInfo(imageListInfo);
        imageListView.hideProgress();
        LogUtils.i("imageListView", "隐藏");
    }

    @Override
    public void error() {
        imageListView.hideFoot();
        imageListView.hideProgress();
        imageListView.netWorkError();
    }
}
