package com.example.y.mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.JokePicAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.JokePicPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.MyRecyclerView;

import java.util.LinkedList;
import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class JokePicFragment extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.LoadingData, BaseView.JokePicView {


    private MyRecyclerView recyclerView;
    private SwipeRefreshLayout srfLayout;

    private boolean isPrepared;
    private boolean isLoad;

    private BasePresenter.JokePicPresenter jokePresenter;
    private JokePicAdapter adapter;


    @Override
    protected View initView() {
        if (view == null) {
            view = View.inflate(getActivity(), R.layout.fragment_joke_pic, null);
            recyclerView = (MyRecyclerView) view.findViewById(R.id.recyclerView);
            srfLayout = (SwipeRefreshLayout) view.findViewById(R.id.srf_layout);
            isPrepared = true;
        }
        return view;
    }

    @Override
    protected void initData() {

        if (!isPrepared || !isVisible || isLoad) {
            return;
        }

        jokePresenter = new JokePicPresenterImpl(this);
        List<JokePicBean.JokePicInfo> jokePicInfos = new LinkedList<>();

        srfLayout.setOnRefreshListener(this);

        adapter = new JokePicAdapter(jokePicInfos);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
        isLoad = true;
    }

    @Override
    public void onRefresh() {
        adapter.removeAll();
        page = 1;
        jokePresenter.requestNetWork(page, isNull);
    }

    @Override
    public void onLoadMore() {
        if (!srfLayout.isRefreshing()) {
            ++page;
            jokePresenter.requestNetWork(page, isNull);
        }
    }

    @Override
    public void setData(List<JokePicBean.JokePicInfo> datas) {
        if (datas.isEmpty()) {
            isNull = true;
        } else {
            adapter.addAll(datas);
        }
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void showProgress() {
        if (!srfLayout.isRefreshing()) {
            srfLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideProgress() {
        if (srfLayout.isRefreshing()) {
            srfLayout.setRefreshing(false);
        }
    }

    @Override
    public void showFoot() {
        adapter.isShowFooter(true);
    }

    @Override
    public void hideFoot() {
        adapter.isShowFooter(false);
    }

}
