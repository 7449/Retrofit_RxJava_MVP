package com.example.y.mvp.adapter;

import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.network.Api;
import com.example.y.mvp.utils.ImageLoaderUtils;
import com.example.y.mvp.utils.RxUtils;
import com.example.y.mvp.utils.SaveImageUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.BasePagerAdapter;

import java.util.List;

import static android.R.attr.id;

/**
 * by y on 2016/5/3.
 */
public class ImageDetailAdapter extends BasePagerAdapter<ImageDetailInfo> implements View.OnLongClickListener {


    public ImageDetailAdapter(List<ImageDetailInfo> datas) {
        super(datas);
    }

    @Override
    protected Object instantiate(final ViewGroup container, final int position, ImageDetailInfo data) {
        final ImageView imageView = new ImageView(container.getContext());
        ImageLoaderUtils.display(imageView, TextUtils.concat(Api.IMAGER_URL, data.getSrc()));
        container.addView(imageView);
        imageView.setOnLongClickListener(this);
        return imageView;
    }

    @Override
    public boolean onLongClick(final View v) {
        new AlertDialog
                .Builder(v.getContext())
                .setMessage(UIUtils.getString(R.string.imageview_message))
                .setPositiveButton(
                        UIUtils.getString(R.string.dialog_ok),
                        (dialog, which) -> {
                            v.setDrawingCacheEnabled(true);
                            RxUtils.getInstance().unSubscription();
                            SaveImageUtils.imageSave((ImageView) v, id);
                        }).create().show();
        return true;
    }
}
