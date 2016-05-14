package com.example.y.mvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.BaseRecyclerViewAdapter;
import com.example.y.mvp.adapter.NewsListAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.mvp.presenter.NewsListPresenter;
import com.example.y.mvp.mvp.presenter.NewsListPresenterImpl;
import com.example.y.mvp.mvp.view.NewsListView;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.MyRecyclerView;

import java.util.LinkedList;
import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class NewsMainFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.LoadingData, NewsListView {

    private boolean isPrepared;
    private boolean isLoad;

    private View inflate;
    private SwipeRefreshLayout srfLayout;
    private MyRecyclerView recyclerView;

    private LinkedList<NewsListInfo> list;
    private NewsListAdapter adapter;
    private NewsListPresenter newsListPresenter;


    private static int page = 1;


    public static Fragment newInstance(int index) {
        Bundle bundle = new Bundle();
        NewsMainFragment fragment = new NewsMainFragment();
        bundle.putInt(FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected View initView() {
        if (inflate == null) {
            inflate = View.inflate(UIUtils.getActivity(), R.layout.fragment_news, null);
            srfLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.srf_layout);
            recyclerView = (MyRecyclerView) inflate.findViewById(R.id.recyclerView);
            isPrepared = true;
        }
        return inflate;
    }

    @Override
    protected void initData() {

        if (!isPrepared || !isVisible || isLoad) {
            return;
        }

        newsListPresenter = new NewsListPresenterImpl(this);
        list = new LinkedList<>();
        adapter = new NewsListAdapter(list);

        srfLayout.setOnRefreshListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener<NewsListInfo>() {
            @Override
            public void onItemClick(View view, int position, NewsListInfo info) {
                newsListPresenter.onClick(info);
            }

            @Override
            public void onItemLongClick(View view, int position, NewsListInfo info) {


            }
        });

        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                srfLayout.setRefreshing(true);
                onRefresh();
            }
        });

        isLoad = true;
    }


    @Override
    public void setNewsListInfo(List<NewsListInfo> newsListInfo) {
        list.addAll(newsListInfo);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        hideFoot();
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
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {
        srfLayout.setRefreshing(false);
    }

    @Override
    public void showFoot() {
        adapter.isShowFooter(true);
    }

    public void hideFoot() {
        adapter.isShowFooter(false);
    }
}
