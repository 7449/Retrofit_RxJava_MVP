package com.example.y.mvp.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.ImageNewAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.ImageNewPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.LoadMoreAdapter;
import com.example.y.mvp.widget.LoadMoreRecyclerView;
import com.example.y.mvp.widget.MVPLazyFragment;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * by 12406 on 2016/5/1.
 */
public class ImageNewFragment extends MVPLazyFragment
        implements BaseView.ImageNewView, SwipeRefreshLayout.OnRefreshListener,
        LoadMoreAdapter.OnItemClickListener<ImageNewInfo> {


    @Bind(R.id.et_id)
    AppCompatEditText etId;

    @Bind(R.id.et_rows)
    AppCompatEditText etRows;

    @Bind(R.id.recyclerView)
    LoadMoreRecyclerView recyclerView;

    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;

    private ImageNewAdapter adapter;
    private BasePresenter.ImageNewPresenter imageNewPresenter;

    public static ImageNewFragment getInstance() {
        return new ImageNewFragment();
    }

    @OnClick({R.id.btn_image})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_image:
                onRefresh();
                break;
        }

    }

    @Override
    public void initActivityCreated() {


        List<ImageNewInfo> data = new LinkedList<>();

        imageNewPresenter = new ImageNewPresenterImpl(this);

        srfLayout.setOnRefreshListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_GRIDVIEW, StaggeredGridLayoutManager.VERTICAL));

        adapter = new ImageNewAdapter(data);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_new_image;
    }


    @Override
    public void setData(List<ImageNewInfo> datas) {
        adapter.addAll(datas);
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {
        if (srfLayout != null)
            srfLayout.setRefreshing(false);
    }

    @Override
    public void showProgress() {
        if (srfLayout != null)
            srfLayout.setRefreshing(true);
    }

    @Override
    public void onRefresh() {
        adapter.removeAll();
        imageNewPresenter.requestNetWork(etId.getText().toString().trim(), etRows.getText().toString().trim());
    }

    @Override
    public void onItemClick(View view, int position, ImageNewInfo info) {
        imageNewPresenter.onClick(info);
    }

    @Override
    public void offKeyBoard() {
        ActivityUtils.offKeyboard(etId);
    }
}
