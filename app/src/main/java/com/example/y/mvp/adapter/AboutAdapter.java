package com.example.y.mvp.adapter;


import com.example.y.mvp.R;
import com.example.y.mvp.widget.LoadMoreAdapter;

import java.util.List;

/**
 * by y on 2016/5/3.
 */
public class AboutAdapter extends LoadMoreAdapter<String> {

    public AboutAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    protected void onBind(com.example.y.mvp.widget.ViewHolder holder, int position, String data) {
        holder.setTextView(R.id.tv_about, data);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.about_item;
    }
}
