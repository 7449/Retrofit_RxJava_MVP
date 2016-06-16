package com.example.y.mvp.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.y.mvp.R;

import java.util.List;

import butterknife.Bind;

/**
 * by y on 2016/5/3.
 */
public class AboutAdapter extends BaseRecyclerViewAdapter<String> {

    public AboutAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, String data) {

        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).setData(data);
        }

    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressWarnings("unused")
    class ViewHolder extends BaseRecyclerViewHolder {


        @SuppressWarnings("unused")
        @Bind(R.id.tv_about)
        TextView tvAbout;

        ViewHolder(View view) {
            super(view);
        }

        @Override
        protected void setData(@NonNull String data) {
            tvAbout.setText(data);
        }

    }
}
