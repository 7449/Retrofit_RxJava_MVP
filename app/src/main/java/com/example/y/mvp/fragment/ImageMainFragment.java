package com.example.y.mvp.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.ImageListAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.ImageListPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.LoadMoreAdapter;
import com.example.y.mvp.widget.LoadMoreRecyclerView;
import com.example.y.mvp.widget.MVPLazyFragment;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * by y on 2016/4/28.
 */
public class ImageMainFragment extends MVPLazyFragment implements SwipeRefreshLayout.OnRefreshListener,
        LoadMoreRecyclerView.LoadMoreListener, LoadMoreAdapter.OnItemClickListener<ImageListInfo>, BaseView.ImageListView {

    @Bind(R.id.recyclerView)
    LoadMoreRecyclerView recyclerView;
    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;

    private ImageListAdapter adapter;
    private BasePresenter.ImageListPresenter imageListPresenter;

    public static ImageMainFragment newInstance(int index) {
        Bundle bundle = new Bundle();
        ImageMainFragment fragment = new ImageMainFragment();
        bundle.putInt(FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected void initActivityCreated() {

        if (!isPrepared || !isVisible || isLoad) {
            return;
        }

        imageListPresenter = new ImageListPresenterImpl(this);

        LinkedList<ImageListInfo> list = new LinkedList<>();

        srfLayout.setOnRefreshListener(this);

        adapter = new ImageListAdapter(list);
        adapter.setOnItemClickListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_GRIDVIEW, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        srfLayout.post(this::onRefresh);
        setLoad();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }


    @Override
    public void setData(List<ImageListInfo> t) {
        adapter.addAll(t);
    }


    @Override
    public void onRefresh() {
        page = 1;
        adapter.removeAll();
        imageListPresenter.requestNetWork(index + 1, page);
    }

    @Override
    public void onLoadMore() {
        if (!srfLayout.isRefreshing()) {
            ++page;
            imageListPresenter.requestNetWork(index + 1, page);
        }
    }


    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void showProgress() {
        if (srfLayout != null)
            srfLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        if (srfLayout != null)
            srfLayout.setRefreshing(false);
    }

    @Override
    public void showFoot() {
        adapter.showFooter();
    }

    public void hideFoot() {
        adapter.hideFooter();
    }

    @Override
    public void onItemClick(View view, int position, ImageListInfo info) {
        imageListPresenter.onClick(info);
    }

}
