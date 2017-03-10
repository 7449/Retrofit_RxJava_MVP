package com.example.y.mvp.widget;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * by y on 2016/5/27.
 */

public abstract class BasePagerAdapter<T> extends PagerAdapter {

    protected List<T> data;

    public BasePagerAdapter(List<T> datas) {
        if (datas != null) {
            this.data = datas;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        return instantiate(container, position, data.get(position));
    }

    protected abstract Object instantiate(ViewGroup container, int position, T data);

}
