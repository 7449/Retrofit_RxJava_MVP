package com.example.y.mvp.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.NewsDetailPresenterImpl;
import com.example.y.mvp.mvp.presenter.ToolBarItemPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.utils.theme.widget.ThemeTextView;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailActivity extends BaseActivity
        implements BaseView.NewsDetailView, BaseView.ToolBarItemView {

    @SuppressWarnings("unused")
    @Bind(R.id.image)
    ImageView image;
    @SuppressWarnings("unused")
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @SuppressWarnings("unused")
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @SuppressWarnings("unused")
    @Bind(R.id.content)
    ThemeTextView content;
    @SuppressWarnings("unused")
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private int id;
    private String message;
    private BasePresenter.ToolBarItemPresenter toolBarItemPresenter;


    public static void startIntent(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        ActivityUtils.startActivity(NewsDetailActivity.class, bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getBundle();
        init();
    }

    private void init() {
        BasePresenter.NewsDetailPresenter newsDetailPresenter = new NewsDetailPresenterImpl(this);
        toolBarItemPresenter = new ToolBarItemPresenterImpl(this);
        newsDetailPresenter.requestNetWork(id);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                toolBarItemPresenter.switchId(item.getItemId());
                return true;
            }
        });

    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            id = bundle.getInt("id");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public void setData(NewsDetailInfo datas) {
        ImageLoaderUtils.display(getApplicationContext(), image, Api.IMAGER_URL + datas.getImg());
        content.setText(Html.fromHtml(datas.getMessage()));
        collapsingToolbar.setTitle(datas.getTitle());
        message = String.valueOf(Html.fromHtml(datas.getMessage()));
    }

    @Override
    public void switchShare() {
        ActivityUtils.share(message);
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }
}
