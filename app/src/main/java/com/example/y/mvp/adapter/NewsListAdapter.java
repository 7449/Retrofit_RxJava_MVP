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
import com.example.y.mvp.activity.WebViewActivity;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.network.Api;
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
            ((ViewHolder) holder).setData(data);
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

        @SuppressWarnings("unused")
        @Bind(R.id.image)
        ImageView image;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_fromname)
        TextView tvFromname;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_time)
        TextView tvTime;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_url)
        TextView tvUrl;

        public ViewHolder(View itemView) {
            super(itemView);
        }


        @SuppressLint("SetTextI18n")
        @Override
        protected void setData(@NonNull final NewsListInfo data) {
            super.setData(data);
            tvTime.setText(UIUtils.getString(R.string.news_time) + TimeUtils.getDateToString(data.getTime()));
            tvTitle.setText(data.getTitle());
            tvUrl.setText(data.getFromurl());
            ImageLoaderUtils.display(UIUtils.getContext(), image, Api.IMAGER_URL + data.getImg());


            tvUrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WebViewActivity.startIntent(data.getFromurl(), data.getTitle());
                }
            });

        }
    }
}
