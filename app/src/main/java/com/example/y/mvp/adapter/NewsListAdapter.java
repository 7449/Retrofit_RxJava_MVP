package com.example.y.mvp.adapter;

import android.text.TextUtils;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.TimeUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.LoadMoreAdapter;
import com.example.y.mvp.widget.ViewHolder;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListAdapter extends LoadMoreAdapter<NewsListInfo> {


    public NewsListAdapter(List<NewsListInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(ViewHolder holder, int position, NewsListInfo data) {
        holder.setTextView(R.id.tv_time, TextUtils.concat(UIUtils.getString(R.string.news_time), TimeUtils.getDateToString(data.getTime())));
        holder.setTextView(R.id.tv_title, data.getTitle());
        holder.setTextView(R.id.tv_url, data.getFromurl());
        ImageLoaderUtils.display(holder.getImageView(R.id.image), TextUtils.concat(Api.IMAGER_URL, data.getImg()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.news_list_item;
    }

}