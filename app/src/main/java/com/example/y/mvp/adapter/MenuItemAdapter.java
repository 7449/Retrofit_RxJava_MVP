package com.example.y.mvp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.y.mvp.R;
import com.example.y.mvp.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * by 12406 on 2016/6/16.
 */
public class MenuItemAdapter extends BaseAdapter {


    private final List<String> mItems;

    public MenuItemAdapter(){
        mItems = new LinkedList<>();
        mItems.add(UIUtils.getString(R.string.list_menu_news));
        mItems.add(UIUtils.getString(R.string.list_menu_image));
        mItems.add(UIUtils.getString(R.string.list_menu_new_image));
        mItems.add(UIUtils.getString(R.string.list_menu_joke));
        mItems.add(UIUtils.getString(R.string.list_menu_about));
        mItems.add(UIUtils.getString(R.string.test));

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, null);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_menu_item);
        textView.setText(mItems.get(position));
        return convertView;
    }
}
