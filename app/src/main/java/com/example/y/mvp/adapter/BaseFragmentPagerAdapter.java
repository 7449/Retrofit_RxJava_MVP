package com.example.y.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * by y on 2016/5/27.
 */
@SuppressWarnings("ALL")
public abstract class BaseFragmentPagerAdapter<T> extends FragmentPagerAdapter {

    private List<T> mData;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<T> mDatas) {
        super(fm);
        this.mData = mDatas;
    }

    @Override
    public Fragment getItem(int position) {
        return getFragmentItem(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getTitle(mData.get(position));
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    protected abstract Fragment getFragmentItem(int position);

    protected abstract CharSequence getTitle(T data);

}
