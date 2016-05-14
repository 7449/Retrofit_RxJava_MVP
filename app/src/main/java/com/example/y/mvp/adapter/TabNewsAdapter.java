package com.example.y.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.y.mvp.fragment.NewsMainFragment;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsAdapter extends FragmentPagerAdapter {


    private final List<TabNewsInfo> mData;

    public TabNewsAdapter(FragmentManager fm, List<TabNewsInfo> mDatas) {
        super(fm);
        this.mData = mDatas;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsMainFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position).getName();
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}

