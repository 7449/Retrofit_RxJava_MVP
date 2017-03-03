package com.example.y.mvp.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.BaseRecyclerViewAdapter;
import com.example.y.mvp.adapter.ImageNewAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.ImageNewPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.MyRecyclerView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * by 12406 on 2016/5/1.
 */
public class ImageNewFragment extends BaseFragment implements BaseView.ImageNewView, SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.LoadingData, BaseRecyclerViewAdapter.OnItemClickListener<ImageNewInfo> {


    @SuppressWarnings("unused")
    @Bind(R.id.et_id)
    MaterialEditText etId;
    @SuppressWarnings("unused")
    @Bind(R.id.et_rows)
    MaterialEditText etRows;
    @SuppressWarnings("unused")
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;
    @SuppressWarnings("unused")
    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;

    private ImageNewAdapter adapter;
    private BasePresenter.ImageNewPresenter imageNewPresenter;


    @SuppressWarnings("unused")
    @OnClick({R.id.btn_image})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_image:
                onRefresh();
                break;
        }

    }

    @Override
    public View initView() {
        return View.inflate(getActivity(), R.layout.fragment_new_image, null);
    }

    @Override
    public void initData() {


        List<ImageNewInfo> data = new LinkedList<>();

        imageNewPresenter = new ImageNewPresenterImpl(this);

        srfLayout.setOnRefreshListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_GRIDVIEW, LinearLayoutManager.VERTICAL));

        adapter = new ImageNewAdapter(data);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void setData(List<ImageNewInfo> datas) {
        if (!datas.isEmpty()) {
            adapter.addAll(datas);
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
    public void showProgress() {
        srfLayout.setRefreshing(true);
    }

    @Override
    public void showFoot() {

    }

    @Override
    public void hideFoot() {

    }

    @Override
    public void onRefresh() {
        adapter.removeAll();
        imageNewPresenter.requestNetWork(etId.getText().toString().trim(), etRows.getText().toString().trim());
    }

    @Override
    public void onLoadMore() {
    }

    @Override
    public void onItemClick(View view, int position, ImageNewInfo info) {
        imageNewPresenter.onClick(info);
    }

    @Override
    public void offKeyBoard() {
        ActivityUtils.offKeyboard(getActivity());
    }
}
