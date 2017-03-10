package com.example.y.mvp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.y.mvp.fragment.ImageListFragment;
import com.example.y.mvp.mvp.model.TabNameInfo;
import com.example.y.mvp.widget.BaseFragmentPagerAdapter;

import java.util.List;

/**
 * by y on 2016/4/28.
 */
public class TabNameAdapter extends BaseFragmentPagerAdapter<TabNameInfo> {


    public TabNameAdapter(FragmentManager fm, List<TabNameInfo> mDatas) {
        super(fm, mDatas);
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return ImageListFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(TabNameInfo data) {
        return data.getName();
    }

}
