package com.example.y.mvp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.ImageDetailAdapter;
import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.ImageDetailPresenterImpl;
import com.example.y.mvp.mvp.presenter.ToolBarItemPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.CompetenceUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.BaseActivity;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;


/**
 * by y on 2016/4/29.
 */
public class ImageDetailActivity extends BaseActivity
        implements BaseView.ImageDetailView, BaseView.ToolBarItemView {


    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Bind(R.id.toolBar)
    Toolbar toolBar;

    private int id;
    private int pos;
    private LinkedList<ImageDetailInfo> list;
    private BasePresenter.ImageDetailPresenter imageDetailPresenter;
    private BasePresenter.ToolBarItemPresenter toolBarItemPresenter;
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
        toolBar.setTitle(UIUtils.getString(R.string.image_detail));
        setSupportActionBar(toolBar);
        CompetenceUtils.storage(this);
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
        toolBarItemPresenter = new ToolBarItemPresenterImpl(this);
        list = new LinkedList<>();
        imageDetailPresenter.requestNetWork(id);
        bigImageAdapter = new ImageDetailAdapter(list);

        toolBar.setOnMenuItemClickListener(item -> {
            toolBarItemPresenter.switchId(item.getItemId());
            return true;
        });

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                pos = position;
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_image_detail;
    }


    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle && !bundle.isEmpty()) {
            id = bundle.getInt("id");
        }
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void setData(List<ImageDetailInfo> datas) {
        if (!datas.isEmpty()) {
            list.addAll(datas);
            viewPager.setAdapter(bigImageAdapter);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void switchShare() {
        ActivityUtils.share(this, TextUtils.concat(Api.IMAGER_URL, list.get(pos).getSrc()));
    }
}
