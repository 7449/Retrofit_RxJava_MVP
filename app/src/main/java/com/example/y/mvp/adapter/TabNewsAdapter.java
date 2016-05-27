package com.example.y.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.y.mvp.fragment.NewsMainFragment;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;

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
        return NewsMainFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(TabNewsInfo data) {
        return data.getName();
    }
}

