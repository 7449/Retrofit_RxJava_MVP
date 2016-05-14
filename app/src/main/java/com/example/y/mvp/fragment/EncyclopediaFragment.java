package com.example.y.mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.BaseRecyclerViewAdapter;
import com.example.y.mvp.adapter.EncyclopediaAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.EncyclopediaInfo;
import com.example.y.mvp.mvp.presenter.EncyclopediaPresenter;
import com.example.y.mvp.mvp.presenter.EncyclopediaPresenterImpl;
import com.example.y.mvp.mvp.view.EncyclopediaView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.MyRecyclerView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * by y on 2016/5/11.
 */
public class EncyclopediaFragment extends BaseFragment implements EncyclopediaView, SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.LoadingData {


    @Bind(R.id.et_keyword)
    MaterialEditText etKeyword;
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;
    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;

    private List<EncyclopediaInfo> data;
    private EncyclopediaPresenter encyclopediaPresenter;
    private EncyclopediaAdapter adapter;
    private static int page = 1;


    @OnClick({R.id.btn_encyclopedia})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_encyclopedia:
                onRefresh();
                ActivityUtils.closeSyskeyBroad();
                break;

        }
    }


    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_encyclopedia, null);
    }

    @Override
    protected void initData() {


        data = new LinkedList<>();
        encyclopediaPresenter = new EncyclopediaPresenterImpl(this);
        adapter = new EncyclopediaAdapter(data);

        srfLayout.setOnRefreshListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener<EncyclopediaInfo>() {
            @Override
            public void onItemClick(View view, int position, EncyclopediaInfo info) {
                encyclopediaPresenter.onClick(info);
            }

            @Override
            public void onItemLongClick(View view, int position, EncyclopediaInfo info) {

            }
        });
    }


    @Override
    public void setEncyclopedia(List<EncyclopediaInfo> encyclopediaInfo) {
        data.addAll(encyclopediaInfo);
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

    @Override
    public void hideFoot() {
        adapter.isShowFooter(false);
    }

    @Override
    public void onRefresh() {
        hideFoot();
        srfLayout.setRefreshing(true);
        adapter.removeAll();
        page = 1;
        encyclopediaPresenter.requestNetWork(etKeyword.getText().toString().trim(), page);
    }

    @Override
    public void onLoadMore() {
        if (!srfLayout.isRefreshing()) {
            ++page;
            encyclopediaPresenter.requestNetWork(etKeyword.getText().toString().trim(), page);
        }
    }
}
