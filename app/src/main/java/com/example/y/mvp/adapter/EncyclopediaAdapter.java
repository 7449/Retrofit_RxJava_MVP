package com.example.y.mvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.EncyclopediaInfo;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.LogUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

import butterknife.Bind;

/**
 * by y on 2016/5/11.
 */
public class EncyclopediaAdapter extends BaseRecyclerViewAdapter<EncyclopediaInfo> {


    public EncyclopediaAdapter(List<EncyclopediaInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, EncyclopediaInfo data) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;

            viewHolder.tvTitle.setText(data.getTitle());
            viewHolder.tvUrl.setText(data.getUrl());

            ImageLoaderUtils.display(UIUtils.getContext(), viewHolder.image, data.getImg());

            LogUtils.i("EncyclopediaAdapter", data.getImg());

        }
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.encyclopedia_item, parent, false);
            return new ViewHolder(view);

        } else if (viewType == TYPE_FOOTER) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false);
            return new BaseRecyclerViewHolder(view);
        }

        return null;
    }

    class ViewHolder extends BaseRecyclerViewHolder {


        @Bind(R.id.image)
        ImageView image;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_url)
        TextView tvUrl;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
