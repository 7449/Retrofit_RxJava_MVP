package com.example.y.mvp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.CacheUitls;
import com.example.y.mvp.utils.RxUtils;
import com.example.y.mvp.utils.SPUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.TransitionActivity;
import com.example.y.mvp.widget.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * by y on 2017/3/10
 */

public class MenuAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<String> list = null;
    private View headerView = null;
    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MenuAdapter() {
        this.list = new ArrayList<>();
        list.add(UIUtils.getString(R.string.list_menu_news));
        list.add(UIUtils.getString(R.string.list_menu_image));
        list.add(UIUtils.getString(R.string.list_menu_new_image));
        list.add(UIUtils.getString(R.string.list_menu_about));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_header, parent, false);
                alterImageTheme();
                onClickTheme();
                return new ViewHolder(headerView);
            default:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER || list == null) {
            return;
        }
        holder.setTextView(R.id.tv_menu_item, list.get(position - 1));

        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(v -> onItemClickListener.onclickItem(v, position - 1, list.get(position - 1)));
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size() + 1;
    }


    private void onClickTheme() {
        headerView.findViewById(R.id.iv).setOnClickListener(v -> {
            RxUtils.getInstance().clearSubscription();
            Activity activity = (Activity) v.getContext();
            activity.setTheme(SPUtils.isTheme(Constant.DAY) ? Constant.NIGHT_STYLES : Constant.DAY_STYLES);
            alterImageTheme();
            SPUtils.setTheme(SPUtils.isTheme(Constant.DAY) ? Constant.NIGHT : Constant.DAY);
            CacheUitls.getInstance().put(Constant.BITMAP_CACHE_KEY, ActivityUtils.captureContent(activity));
            TransitionActivity.startIntent();
        });
    }

    private void alterImageTheme() {
        headerView.findViewById(R.id.iv).setBackgroundResource(SPUtils.isTheme(Constant.DAY) ? R.drawable.day : R.drawable.night);
    }

    public interface OnItemClickListener {
        void onclickItem(View view, int position, String data);
    }
}
