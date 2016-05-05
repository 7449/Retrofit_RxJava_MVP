package com.example.y.mvp.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.y.mvp.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * by y on 2016/4/28.
 */
@SuppressWarnings("ALL")
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    static final int TYPE_ITEM = 0;
    static final int TYPE_FOOTER = 1;
    private List<T> mDatas = new LinkedList<>();
    private OnItemClickListener<T> mOnItemClickListener;
    private boolean showFoot = false;

    public BaseRecyclerViewAdapter(List<T> datas) {
        if (datas != null) {
            mDatas = datas;
        }
    }


    public void addItemLast(List<T> datas) {
        mDatas.addAll(datas);
    }

    public void addItemTop(List<T> datas) {
        mDatas = datas;
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyDataSetChanged();
    }

    public void removeAll() {
        if (mDatas.size() != 0) {
            mDatas.clear();
        }
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        int type = showFoot ? 1 : 0;
        if (mDatas == null) {
            return type;
        }
        return mDatas.size() + type;
    }

    @Override
    public int getItemViewType(int position) {
        if (!showFoot) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    public void isShowFooter(boolean showFoot) {
        this.showFoot = showFoot;
    }

    public boolean isShowFooter() {
        return this.showFoot;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public interface OnItemClickListener<T> {

        void onItemClick(View view, int position, T info);

        void onItemLongClick(View view, int position, T info);

    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreate(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (getItemViewType(position) == TYPE_FOOTER) {
            return;
        }
        final int pos = getRealPosition(holder);
        final T data = mDatas.get(position);
        if (data == null) {
            return;
        }
        onBind(holder, position, data);

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, pos, data);
                    mOnItemClickListener.onItemLongClick(v, pos, data);
                }
            });
        }

    }


    private int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return LayoutInflater.from(UIUtils.getContext()) == null ? position : position - 1;
    }

    protected abstract void onBind(RecyclerView.ViewHolder holder, int position, T data);

    protected abstract BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType);


    class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {

        public BaseRecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

