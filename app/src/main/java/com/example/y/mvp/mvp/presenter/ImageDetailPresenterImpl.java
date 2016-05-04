package com.example.y.mvp.mvp.presenter;


import android.content.pm.PackageManager;
import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.mvp.model.ImageDetailModel;
import com.example.y.mvp.mvp.model.ImageDetailModelImpl;
import com.example.y.mvp.mvp.view.ImageDetailView;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailPresenterImpl implements ImageDetailPresenter, ImageDetailModelImpl.ImageDetailData {

    private final ImageDetailView imageDetailView;
    private final ImageDetailModel imageDetailModel;

    public ImageDetailPresenterImpl(ImageDetailView imageDetailView) {
        this.imageDetailView = imageDetailView;
        this.imageDetailModel = new ImageDetailModelImpl();
    }


    @Override
    public void requestNetWork(int id) {
        imageDetailModel.netWorkDetail(id, this);
    }

    @Override
    public void competence(int requestCode, int[] grantResults) {
        if (requestCode == Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.competence_error), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void addData(List<ImageDetailInfo> imageDetailInfo) {
        if (imageDetailInfo.size() == 0) {
            return;
        }
        imageDetailView.setImageDetailInfo(imageDetailInfo);
    }

    @Override
    public void error() {
        imageDetailView.netWorkError();
    }
}
