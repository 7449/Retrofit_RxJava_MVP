package com.example.y.mvp.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.DiaLogUtils;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.LogUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * Created by y on 2016/5/3.
 */
public class ImageDetailAdapter extends PagerAdapter {

    private List<ImageDetailInfo> info;

    public ImageDetailAdapter(List<ImageDetailInfo> info) {
        this.info = info;
    }

    @Override
    public int getCount() {
        return info.size();
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
    public Object instantiateItem(ViewGroup container, final int position) {
        final ImageView imageView = new ImageView(UIUtils.getContext());
        LogUtils.i("bigimage -->  adapter", position + "--> 加载");
        ImageLoaderUtils.display(UIUtils.getActivity(), imageView, Api.IMAGER_URL + info.get(position).getSrc());
        container.addView(imageView);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DiaLogUtils.iamgeViewDialog(UIUtils.getActivity(), imageView, position);
                return true;
            }
        });
        return imageView;
    }

}
