package com.example.y.mvp.mvp.presenter;


import android.text.TextUtils;
import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.model.ImageNewInfo;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.Network;
import com.example.y.mvp.utils.UIUtils;

/**
 * by y on 2016/4/29.
 */
public class ImageNewPresenterImpl extends BasePresenterImpl<BaseView.ImageNewView, BaseBean.ImageNewBean>
        implements Presenter.ImageNewPresenter {


    public ImageNewPresenterImpl(BaseView.ImageNewView view) {
        super(view);
    }

    @Override
    protected void onNetWorkSuccess(BaseBean.ImageNewBean imageNewBean) {
        view.setData(imageNewBean.getTngou());
        view.hideProgress();
    }

    @Override
    protected void onNetWorkError() {
        view.hideProgress();
        view.netWorkError();
    }

    @Override
    public void requestNetWork(String id, String rows) {
        if (TextUtils.isEmpty(id)) {
            view.hideProgress();
            Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.image_new_id), Toast.LENGTH_LONG).show();
        } else {
            if (TextUtils.isEmpty(rows)) {
                rows = "20";
            }
            view.offKeyBoard();
            view.showProgress();
            startNetWork(Network.getTngouApi().getImageNews(Integer.valueOf(id), Integer.valueOf(rows)));
        }
    }

    @Override
    public void onClick(ImageNewInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }
}
