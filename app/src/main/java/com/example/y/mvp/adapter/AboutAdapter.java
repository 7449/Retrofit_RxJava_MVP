package com.example.y.mvp.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.y.mvp.R;

import java.util.List;

import butterknife.Bind;

/**
 * Created by y on 2016/5/3.
 */
public class AboutAdapter extends BaseRecyclerViewAdapter<String> {

    public AboutAdapter(Activity activity, List<String> datas) {
        super(activity, datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, String data) {

        if (holder instanceof ViewHolder) {
            final ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.tvAbout.setText(data);
        }

    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_item, parent, false);
        return new ViewHolder(view);
    }

    class ViewHolder extends BaseRecyclerViewHolder {

        @Bind(R.id.tv_about)
        TextView tvAbout;

        ViewHolder(View view) {
            super(view);
        }
    }
}
