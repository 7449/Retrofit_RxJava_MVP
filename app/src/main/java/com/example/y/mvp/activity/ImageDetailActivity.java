package com.example.y.mvp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.ImageDetailAdapter;
import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.mvp.presenter.ImageDetailPresenter;
import com.example.y.mvp.mvp.presenter.ImageDetailPresenterImpl;
import com.example.y.mvp.mvp.view.ImageDetailView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.CompetenceUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;


/**
 * by y on 2016/4/29.
 */
public class ImageDetailActivity extends BaseActivity implements ImageDetailView {


    @SuppressWarnings("unused")
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    private int id;
    private LinkedList<ImageDetailInfo> list;
    private ImageDetailPresenter imageDetailPresenter;
    private ImageDetailAdapter bigImageAdapter;


    public static void startIntent(int id, String title) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        bundle.putString("title", title);
        ActivityUtils.startActivity(ImageDetailActivity.class, bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        CompetenceUtils.Storage();
        getBundle();
        init();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        imageDetailPresenter.competence(requestCode, grantResults);
    }


    private void init() {
        imageDetailPresenter = new ImageDetailPresenterImpl(this);
        list = new LinkedList<>();
        imageDetailPresenter.requestNetWork(id);
        bigImageAdapter = new ImageDetailAdapter(list);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_image_detail;
    }


    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            id = bundle.getInt("id");
        }
    }


    @Override
    public void setImageDetailInfo(List<ImageDetailInfo> imageDetailInfo) {
        if (!imageDetailInfo.isEmpty()) {
            list.addAll(imageDetailInfo);
            viewPager.setAdapter(bigImageAdapter);
        }
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

}
