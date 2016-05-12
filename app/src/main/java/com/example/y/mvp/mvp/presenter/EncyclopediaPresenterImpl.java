package com.example.y.mvp.mvp.presenter;

import android.os.Bundle;
import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.activity.WebViewActivity;
import com.example.y.mvp.mvp.Bean.EncyclopediaInfo;
import com.example.y.mvp.mvp.model.EncyclopediaModel;
import com.example.y.mvp.mvp.model.EncyclopediaModelImpl;
import com.example.y.mvp.mvp.view.EncyclopediaView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/5/11.
 */
public class EncyclopediaPresenterImpl implements EncyclopediaPresenter, EncyclopediaModelImpl.EncycloedData {

    private final EncyclopediaView encyclopediaView;
    private final EncyclopediaModel encyclopediaModel;

    public EncyclopediaPresenterImpl(EncyclopediaView encyclopediaView) {
        this.encyclopediaView = encyclopediaView;
        this.encyclopediaModel = new EncyclopediaModelImpl();
    }


    @Override
    public void requestNetWork(String keyword, int page) {
        if (page != 1) {
            encyclopediaView.showFoot();
        }
        if (keyword.isEmpty()) {
            encyclopediaView.hideProgress();
            Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.encyclopedia_keywork), Toast.LENGTH_LONG).show();
        } else {
            encyclopediaModel.netWorkEncyclopedia(keyword, page, this);
        }
    }

    @Override
    public void onClick(EncyclopediaInfo info) {
        Bundle bundle = new Bundle();
        bundle.putString("url", info.getUrl());
        bundle.putString("title",info.getTitle());
        ActivityUtils.startActivity(WebViewActivity.class, bundle);
    }

    @Override
    public void addData(List<EncyclopediaInfo> encyclopediaInfo) {
        if (encyclopediaInfo.size() == 0) {
            encyclopediaView.hideFoot();
            encyclopediaView.hideProgress();
        }
        encyclopediaView.setEncyclopedia(encyclopediaInfo);
        encyclopediaView.hideProgress();

    }

    @Override
    public void error() {
        encyclopediaView.hideProgress();
        encyclopediaView.netWorkError();
        encyclopediaView.hideFoot();
    }
}
