package com.example.y.mvp.adapter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.y.mvp.R;
import com.example.y.mvp.activity.WebViewActivity;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.TimeUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListAdapter extends BaseRecyclerViewAdapter<NewsListInfo> {


    public NewsListAdapter(List<NewsListInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, final NewsListInfo data) {
        if (holder instanceof ViewHolder) {
            final ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.tvFromname.setText(UIUtils.getString(R.string.news_fromname) + data.getFromname());
            viewHolder.tvTime.setText(UIUtils.getString(R.string.news_time) + TimeUtils.getDateToString(data.getTime()));
            viewHolder.tvTitle.setText(data.getTitle());
            viewHolder.tvUrl.setText(data.getFromurl());
            ImageLoaderUtils.display(UIUtils.getContext(), viewHolder.image, Api.IMAGER_URL + data.getImg());


            viewHolder.tvUrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", data.getFromurl());
                    bundle.putString("title", data.getTitle());
                    ActivityUtils.startActivity(WebViewActivity.class, bundle);
                }
            });
        }
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
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
        @Bind(R.id.tv_fromname)
        TextView tvFromname;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_url)
        TextView tvUrl;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
