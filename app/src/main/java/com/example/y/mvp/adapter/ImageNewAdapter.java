package com.example.y.mvp.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/1.
 */
public class ImageNewAdapter extends BaseRecyclerViewAdapter<ImageNewInfo> {


    public ImageNewAdapter(Activity activity, List<ImageNewInfo> datas) {
        super(activity, datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, ImageNewInfo data) {
        if (holder instanceof ViewHolder) {
            final ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.tvTitle.setText(data.getTitle());
            viewHolder.tvSize.setText(data.getSize() + UIUtils.getString(R.string.list_adapter_number));
            viewHolder.tvCount.setText(UIUtils.getString(R.string.list_adapter_views) + data.getCount());
            ImageLoaderUtils.display(activity, viewHolder.iv, Api.IMAGER_URL + data.getImg());
        }
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_new_item, parent, false);
        return new ViewHolder(view);
    }

    class ViewHolder extends BaseRecyclerViewHolder {

        @Bind(R.id.image)
        ImageView iv;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_size)
        TextView tvSize;
        @Bind(R.id.tv_count)
        TextView tvCount;

        ViewHolder(View view) {
            super(view);
        }
    }
}

