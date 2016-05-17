package com.example.y.mvp.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.TabNewsAdapter;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;
import com.example.y.mvp.mvp.presenter.TabNewsPresenter;
import com.example.y.mvp.mvp.presenter.TabNewsPresenterImpl;
import com.example.y.mvp.mvp.view.TabNewsView;
import com.example.y.mvp.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/14.
 */
public class NewsViewPagerFragment extends BaseFragment implements TabNewsView {

    @SuppressWarnings("unused")
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @SuppressWarnings("unused")
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private List<TabNewsInfo> data;
    private TabNewsAdapter tabNewsAdapter;

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_viewpager, null);
    }

    @Override
    protected void initData() {

        TabNewsPresenter tabNewsPresenter = new TabNewsPresenterImpl(this);
        tabNewsPresenter.requestNetWork();

        data = new LinkedList<>();
        tabNewsAdapter = new TabNewsAdapter(getChildFragmentManager(), data);
    }

    @Override
    public void addTabName(List<TabNewsInfo> tabNewsInfo) {
        if (!tabNewsInfo.isEmpty()) {
            data.addAll(tabNewsInfo);
            viewPager.setAdapter(tabNewsAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getContext().getResources().getString(R.string.network_error));
    }
}
