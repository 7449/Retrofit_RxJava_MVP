package com.example.y.mvp.mvp.presenter;


import android.content.pm.PackageManager;
import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.mvp.model.BaseDataBridge;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.ImageDetailModelImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailPresenterImpl extends BasePresenterImpl<BaseView.ImageDetailView>
        implements BasePresenter.ImageDetailPresenter, BaseDataBridge.ImageDetailData {

    private final BaseModel.ImageDetailModel imageDetailModel;

    public ImageDetailPresenterImpl(BaseView.ImageDetailView view) {
        super(view);
        this.imageDetailModel = new ImageDetailModelImpl();
    }


    @Override
    public void requestNetWork(int id) {
        imageDetailModel.netWorkDetail(id, this);
    }

    @Override
    public void competence(int requestCode, int[] grantResults) {
        if (requestCode == Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            //noinspection StatementWithEmptyBody
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.competence_error), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void addData(List<ImageDetailInfo> imageDetailInfo) {
        view.setData(imageDetailInfo);
    }

    @Override
    public void error() {
        view.netWorkError();
    }
}
