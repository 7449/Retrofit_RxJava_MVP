package com.example.y.mvp.mvp.presenter;


import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.model.ImageNewModel;
import com.example.y.mvp.mvp.model.ImageNewModelImpl;
import com.example.y.mvp.mvp.view.ImageNewView;
import com.example.y.mvp.utils.UIUtils;

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
    public void requestNetWork(String id, String rows) {

        if (id.isEmpty()) {
            imageNewView.hideProgress();
            Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.image_new_id), Toast.LENGTH_LONG).show();
        } else {
            if (rows.isEmpty()) {
                rows = "20";
            }
            imageNewView.showProgress();
            imageNewModel.netWorkNew(Integer.valueOf(id), Integer.valueOf(rows), this);
        }
    }

    @Override
    public void onClick(ImageNewInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

    @Override
    public void addData(List<ImageNewInfo> imageNewInfo) {
        if (!imageNewInfo.isEmpty()) {
            imageNewView.setImageNewInfo(imageNewInfo);
        }
        imageNewView.hideProgress();
    }

    @Override
    public void error() {
        imageNewView.hideProgress();
        imageNewView.netWorkError();
    }
}
