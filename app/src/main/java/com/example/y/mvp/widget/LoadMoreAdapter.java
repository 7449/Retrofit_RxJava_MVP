package com.example.y.mvp.widget;


import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.y.mvp.R;

import java.util.LinkedList;
import java.util.List;

/**
 * by y on 2016/4/28.
 */

public abstract class LoadMoreAdapter<T> extends RecyclerView.Adapter<ViewHolder> {


    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    private List<T> mDatas = new LinkedList<>();
    private OnItemClickListener<T> mOnItemClickListener;
    private OnItemLongClickListener<T> mOnLongClickListener;
    private View footerView = null;

    public LoadMoreAdapter(@NonNull List<T> datas) {
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_FOOTER:
                footerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false);
                return new ViewHolder(footerView);
            default:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false));
        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (getItemViewType(position) == TYPE_FOOTER || mDatas == null) {
            return;
        }
        final T data = mDatas.get(position);
        if (data == null) {
            return;
        }
        onBind(holder, position, data);
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(v -> mOnItemClickListener.onItemClick(v, position, data));
        }
        if (mOnLongClickListener != null) {
            holder.itemView.setOnLongClickListener(v -> {
                mOnLongClickListener.onLongClick(v, position, data);
                return true;
            });
        }

    }


    protected abstract void onBind(ViewHolder holder, int position, T data);

    protected abstract int getLayoutId();


    public void addAll(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addItemTop(List<T> datas) {
        mDatas = datas;
    }

    public void remove(int position) {
        if (mDatas != null) {
            mDatas.remove(position);
            notifyDataSetChanged();
        }
    }

    public void removeAll() {
        if (mDatas != null) {
            mDatas.clear();
            notifyDataSetChanged();
        }
    }

    public void showFooter() {
        if (footerView != null) {
            footerView.setVisibility(View.VISIBLE);
        }
    }

    public void hideFooter() {
        if (footerView != null) {
            footerView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == getItemCount() - 1 ? TYPE_FOOTER : TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size() + 1;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.mOnItemClickListener = listener;
    }

    public void setOnLongClickListener(OnItemLongClickListener<T> listener) {
        this.mOnLongClickListener = listener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (!(getItemViewType(position) == TYPE_ITEM)) {
                        return gridManager.getSpanCount();
                    } else {
                        return 1;
                    }
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams stagger = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            if (!(getItemViewType(holder.getLayoutPosition()) == TYPE_ITEM)) {
                stagger.setFullSpan(true);
            } else {
                stagger.setFullSpan(false);
            }
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T info);
    }

    public interface OnItemLongClickListener<T> {
        void onLongClick(View view, int position, T info);
    }
}

