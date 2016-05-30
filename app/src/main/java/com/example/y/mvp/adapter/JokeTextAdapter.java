package com.example.y.mvp.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

import butterknife.Bind;

/**
 * by y on 2016/5/30.
 */
public class JokeTextAdapter extends BaseRecyclerViewAdapter<JokeTextBean.JokeTextInfo> {


    public JokeTextAdapter(List<JokeTextBean.JokeTextInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, JokeTextBean.JokeTextInfo data) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).setData(data);
        }
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_text_list_item, parent, false);
            return new ViewHolder(view);

        } else if (viewType == TYPE_FOOTER) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false);
            return new BaseRecyclerViewHolder(view);
        }

        return null;
    }

    class ViewHolder extends BaseRecyclerViewHolder {


        @SuppressWarnings("unused")
        @Bind(R.id.tv_time)
        TextView tvTime;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_text)
        TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void setData(@NonNull JokeTextBean.JokeTextInfo data) {
            super.setData(data);
            tvTime.setText(UIUtils.getString(R.string.news_time) + data.getCt());
            tvText.setText(Html.fromHtml(data.getText()));
        }
    }
}
