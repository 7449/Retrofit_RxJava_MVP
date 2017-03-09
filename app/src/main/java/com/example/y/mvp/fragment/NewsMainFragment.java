package com.example.y.mvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.NewsListAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.NewsListPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.LoadMoreAdapter;
import com.example.y.mvp.widget.LoadMoreRecyclerView;
import com.example.y.mvp.widget.MVPLazyFragment;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/14.
 */
public class NewsMainFragment extends MVPLazyFragment implements SwipeRefreshLayout.OnRefreshListener,
        LoadMoreRecyclerView.LoadMoreListener, BaseView.NewsListView, LoadMoreAdapter.OnItemClickListener<NewsListInfo> {

    @Bind(R.id.recyclerView)
    LoadMoreRecyclerView recyclerView;
    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;

    private NewsListAdapter adapter;
    private BasePresenter.NewsListPresenter newsListPresenter;

    public static Fragment newInstance(int index) {
        Bundle bundle = new Bundle();
        NewsMainFragment fragment = new NewsMainFragment();
        bundle.putInt(FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected void initActivityCreated() {
        if (!isPrepared || !isVisible || isLoad) {
            return;
        }
        newsListPresenter = new NewsListPresenterImpl(this);
        LinkedList<NewsListInfo> list = new LinkedList<>();
        adapter = new NewsListAdapter(list);
        adapter.setOnItemClickListener(this);
        srfLayout.setOnRefreshListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });

        setLoad();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }


    @Override
    public void onRefresh() {
        page = 1;
        adapter.removeAll();
        newsListPresenter.requestNetWork(index + 1, page);
    }

    @Override
    public void onLoadMore() {
        if (!srfLayout.isRefreshing()) {
            ++page;
            newsListPresenter.requestNetWork(index + 1, page);
        }
    }


    @Override
    public void setData(List<NewsListInfo> datas) {
        adapter.addAll(datas);
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
    public void onItemClick(View view, int position, NewsListInfo info) {
        newsListPresenter.onClick(info);
    }
}
