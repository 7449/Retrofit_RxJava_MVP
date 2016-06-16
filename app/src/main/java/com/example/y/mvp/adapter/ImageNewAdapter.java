package com.example.y.mvp.adapter;


import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.utils.theme.widget.ThemeTextView;

import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/1.
 */
public class ImageNewAdapter extends BaseRecyclerViewAdapter<ImageNewInfo> {


    public ImageNewAdapter(List<ImageNewInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, ImageNewInfo data) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).setData(data);
        }
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_new_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressWarnings("unused")
    class ViewHolder extends BaseRecyclerViewHolder {

        @Bind(R.id.image)
        ImageView image;
        @Bind(R.id.tv_title)
        ThemeTextView tvTitle;
        @Bind(R.id.tv_size)
        ThemeTextView tvSize;
        @Bind(R.id.tv_count)
        ThemeTextView tvCount;

        ViewHolder(View view) {
            super(view);
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void setData(@NonNull ImageNewInfo data) {
            super.setData(data);
            tvTitle.setText(data.getTitle());
            tvSize.setText(data.getSize() + UIUtils.getString(R.string.list_adapter_number));
            tvCount.setText(UIUtils.getString(R.string.list_adapter_views) + data.getCount());
            ImageLoaderUtils.display(UIUtils.getContext(), image, Api.IMAGER_URL + data.getImg());
        }
    }
}

