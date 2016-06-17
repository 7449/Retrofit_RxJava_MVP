package com.example.y.mvp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.DiaLogUtils;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/5/3.
 */
public class ImageDetailAdapter extends BasePagerAdapter<ImageDetailInfo> {


    public ImageDetailAdapter(List<ImageDetailInfo> datas) {
        super(datas);
    }

    @Override
    protected Object instantiate(ViewGroup container, final int position, ImageDetailInfo data) {
        final ImageView imageView = new ImageView(UIUtils.getContext());
        ImageLoaderUtils.display(UIUtils.getActivity(), imageView, Api.IMAGER_URL + data.getSrc());
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
