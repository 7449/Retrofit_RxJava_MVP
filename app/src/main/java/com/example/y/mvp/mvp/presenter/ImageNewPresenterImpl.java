package com.example.y.mvp.mvp.presenter;


import android.os.Bundle;

import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.model.ImageNewModel;
import com.example.y.mvp.mvp.model.ImageNewModelImpl;
import com.example.y.mvp.mvp.view.ImageNewView;
import com.example.y.mvp.utils.ActivityUtils;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageNewPresenterImpl implements ImageNewPresenter, ImageNewModelImpl.ImageNewData {

    private final ImageNewView imageNewView;
    private final ImageNewModel imageNewModel;

    public ImageNewPresenterImpl(ImageNewView imageNewView) {
        this.imageNewView = imageNewView;
        imageNewModel = new ImageNewModelImpl();
    }


    @Override
    public void requestNetWork(int id, int rows) {
        imageNewModel.netWorkNew(id, rows, this);
    }

    @Override
    public void onClick(ImageNewInfo info) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", info.getId());
        bundle.putString("title", info.getTitle());
        ActivityUtils.startActivity(ImageDetailActivity.class, bundle);
    }

    @Override
    public void addData(List<ImageNewInfo> imageNewInfo) {
        imageNewView.setImageNewInfo(imageNewInfo);
        imageNewView.hideProgress();
    }

    @Override
    public void error() {
        imageNewView.hideProgress();
        imageNewView.netWorkError();
    }
}
