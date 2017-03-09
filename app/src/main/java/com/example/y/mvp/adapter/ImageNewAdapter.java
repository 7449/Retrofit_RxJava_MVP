package com.example.y.mvp.adapter;


import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.LoadMoreAdapter;
import com.example.y.mvp.widget.ViewHolder;

import java.util.List;

/**
 * by 12406 on 2016/5/1.
 */
public class ImageNewAdapter extends LoadMoreAdapter<ImageNewInfo> {


    public ImageNewAdapter(List<ImageNewInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(ViewHolder holder, int position, ImageNewInfo data) {
        holder.setTextView(R.id.tv_title, data.getTitle());
        holder.setTextView(R.id.tv_size, data.getSize() + UIUtils.getString(R.string.list_adapter_number));
        holder.setTextView(R.id.tv_count, UIUtils.getString(R.string.list_adapter_views) + data.getCount());
        ImageLoaderUtils.display(holder.getImageView(R.id.image), Api.IMAGER_URL + data.getImg());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.image_new_item;
    }

}

