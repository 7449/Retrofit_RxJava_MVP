package com.example.y.mvp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.y.mvp.fragment.NewsListFragment;
import com.example.y.mvp.mvp.model.TabNewsInfo;
import com.example.y.mvp.widget.BaseFragmentPagerAdapter;

import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsAdapter extends BaseFragmentPagerAdapter<TabNewsInfo> {


    public TabNewsAdapter(FragmentManager fm, List<TabNewsInfo> mDatas) {
        super(fm, mDatas);
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return NewsListFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(TabNewsInfo data) {
        return data.getName();
    }
}

