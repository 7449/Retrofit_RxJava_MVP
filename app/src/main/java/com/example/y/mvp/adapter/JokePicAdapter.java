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
import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

import butterknife.Bind;

/**
 * by y on 2016/5/30.
 */
public class JokePicAdapter extends BaseRecyclerViewAdapter<JokePicBean.JokePicInfo> {


    public JokePicAdapter(List<JokePicBean.JokePicInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, JokePicBean.JokePicInfo data) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).setData(data);
        }
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ITEM:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_pic_list_item, parent, false));
            default:
                return new BaseRecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false));
        }
    }

    class ViewHolder extends BaseRecyclerViewHolder {


        @SuppressWarnings("unused")
        @Bind(R.id.tv_time)
        TextView tvTime;
        @SuppressWarnings("unused")
        @Bind(R.id.image)
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void setData(@NonNull JokePicBean.JokePicInfo data) {
            super.setData(data);
            tvTime.setText(data.getTitle());
            ImageLoaderUtils.display(UIUtils.getContext(), image, data.getImg());
        }
    }
}
