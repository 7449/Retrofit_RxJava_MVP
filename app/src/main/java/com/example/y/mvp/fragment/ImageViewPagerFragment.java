package com.example.y.mvp.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.TabNameAdapter;
import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.TabNamePresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.widget.MVPLazyFragment;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/1.
 */
public class ImageViewPagerFragment extends MVPLazyFragment implements BaseView.TabNameView {


    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private TabNameAdapter tabNameAdapter;
    private List<TabNameInfo> data;

    public static ImageViewPagerFragment getInstance() {
        return new ImageViewPagerFragment();
    }

    @Override
    public void initActivityCreated() {


        BasePresenter.TabNamePresenter tabNamePresenter = new TabNamePresenterImpl(this);
        tabNamePresenter.requestNetWork();

        data = new LinkedList<>();
        tabNameAdapter = new TabNameAdapter(getChildFragmentManager(), data);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_viewpager;
    }


    @Override
    public void setData(List<TabNameInfo> datas) {
        if (!datas.isEmpty()) {
            data.addAll(datas);
            viewPager.setAdapter(tabNameAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void netWorkError() {
        Toast(getString(R.string.network_error));
    }

}
