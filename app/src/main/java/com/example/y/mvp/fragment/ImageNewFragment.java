package com.example.y.mvp.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.BaseRecyclerViewAdapter;
import com.example.y.mvp.adapter.ImageNewAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.presenter.ImageNewPresenter;
import com.example.y.mvp.mvp.presenter.ImageNewPresenterImpl;
import com.example.y.mvp.mvp.view.ImageNewView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.MyRecyclerView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/1.
 */
public class ImageNewFragment extends BaseFragment implements ImageNewView, SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.LoadingData {


    @SuppressWarnings("unused")
    @Bind(R.id.et_id)
    MaterialEditText etId;
    @SuppressWarnings("unused")
    @Bind(R.id.et_rows)
    MaterialEditText etRows;
    @SuppressWarnings("unused")
    @Bind(R.id.btn_image)
    Button btImage;
    @SuppressWarnings("unused")
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;
    @SuppressWarnings("unused")
    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;

    private List<ImageNewInfo> data;
    private ImageNewAdapter adapter;
    private ImageNewPresenter imageNewPresenter;

    @Override
    public View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_new_image, null);
    }

    @Override
    public void initData() {


        data = new LinkedList<>();

        imageNewPresenter = new ImageNewPresenterImpl(this);

        srfLayout.setOnRefreshListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_GRIDVIEW, LinearLayoutManager.VERTICAL));

        adapter = new ImageNewAdapter(data);
        recyclerView.setAdapter(adapter);

        btImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onRefresh();
                ActivityUtils.closeSyskeyBroad();
            }


        });

        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener<ImageNewInfo>() {
            @Override
            public void onItemClick(View view, int position, ImageNewInfo info) {

                imageNewPresenter.onClick(info);
            }

            @Override
            public void onItemLongClick(View view, int position, ImageNewInfo info) {

            }
        });
    }

    @Override
    public void setImageNewInfo(List<ImageNewInfo> imageNewInfo) {
        data.addAll(imageNewInfo);
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
    public void onRefresh() {
        srfLayout.setRefreshing(true);
        adapter.removeAll();
        imageNewPresenter.requestNetWork(etId.getText().toString().trim(), etRows.getText().toString().trim());
    }

    @Override
    public void onLoadMore() {
    }

}
