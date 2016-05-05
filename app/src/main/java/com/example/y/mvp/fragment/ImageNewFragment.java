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


    @Bind(R.id.et_id)
    MaterialEditText etId;
    @Bind(R.id.et_rows)
    MaterialEditText etRows;
    @Bind(R.id.btn_image)
    Button btImage;
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;
    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;

    private List<ImageNewInfo> data;
    private ImageNewAdapter adapter;
    private int id;
    private int rows;


    ImageNewPresenter imageNewPresenter;

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
                if (isNull()) {
                    return;
                }
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
        if (imageNewInfo.size() != 0) {
            data.addAll(imageNewInfo);
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
    public void onRefresh() {
        srfLayout.setRefreshing(true);
        adapter.removeAll();
        if (isNull()) {
            srfLayout.setRefreshing(false);
            return;
        }
        if (id > 100000 || rows > 100000) {
            Toast(UIUtils.getString(R.string.number_big));
            srfLayout.setRefreshing(false);
            return;
        }
        imageNewPresenter.requestNetWork(id, rows);
    }

    @Override
    public void onLoadMore() {
    }

    private boolean isNull() {
        if (etId.getText().toString().trim().isEmpty()) {
            Toast(UIUtils.getString(R.string.image_new_id));
            return true;
        } else {
            if (etRows.getText().toString().trim().isEmpty()) {
                rows = 20;
            } else {
                rows = Integer.valueOf(etRows.getText().toString().trim());
            }
            id = Integer.valueOf(etId.getText().toString().trim());
        }
        return false;
    }

}
