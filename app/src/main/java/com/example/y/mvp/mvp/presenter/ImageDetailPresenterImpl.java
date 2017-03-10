package com.example.y.mvp.mvp.presenter;


import android.content.pm.PackageManager;
import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.Network;
import com.example.y.mvp.utils.UIUtils;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailPresenterImpl extends BasePresenterImpl<BaseView.ImageDetailView, BaseBean.ImageDetailBean>
        implements Presenter.ImageDetailPresenter {


    public ImageDetailPresenterImpl(BaseView.ImageDetailView view) {
        super(view);
    }

    @Override
    public void requestNetWork(int id) {
        startNetWork(Network.getTngouApi().getImageDetail(id));
    }

    @Override
    protected void onNetWorkSuccess(BaseBean.ImageDetailBean imageDetailBean) {
        view.setData(imageDetailBean.getList());
    }


    @Override
    protected void onNetWorkError() {
        view.netWorkError();
    }


    @Override
    public void competence(int requestCode, int[] grantResults) {
        if (requestCode == Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.competence_error), Toast.LENGTH_LONG).show();
            }
        }
    }

}
