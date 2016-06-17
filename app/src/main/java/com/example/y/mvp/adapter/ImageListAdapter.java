package com.example.y.mvp.adapter;


import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

import butterknife.Bind;

/**
 * by y on 2016/4/28.
 */
public class ImageListAdapter extends BaseRecyclerViewAdapter<ImageListInfo> {


    public ImageListAdapter(List<ImageListInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, final int position, final ImageListInfo data) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).setData(data);
        }
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_item, parent, false);
            return new ViewHolder(view);

        } else if (viewType == TYPE_FOOTER) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false);
            return new BaseRecyclerViewHolder(view);
        }

        return null;

    }


    class ViewHolder extends BaseRecyclerViewHolder {

        @SuppressWarnings("unused")
        @Bind(R.id.image)
        ImageView iv;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_size)
        TextView tvSize;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_count)
        TextView tvCount;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void setData(@NonNull ImageListInfo data) {
            super.setData(data);
            tvTitle.setText(data.getTitle());
            tvSize.setText(data.getSize() + UIUtils.getString(R.string.list_adapter_number));
            tvCount.setText(UIUtils.getString(R.string.list_adapter_views) + data.getCount());
            ImageLoaderUtils.display(UIUtils.getContext(), iv, Api.IMAGER_URL + data.getImg());
        }
    }
}
