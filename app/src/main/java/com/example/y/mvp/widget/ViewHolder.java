package com.example.y.mvp.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * by y on 2017/3/9.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    public ViewHolder(View itemView) {
        super(itemView);
    }

    public <T extends View> T getView(int id) {
        SparseArray<View> viewSparseArray = (SparseArray<View>) itemView.getTag();
        if (null == viewSparseArray) {
            viewSparseArray = new SparseArray<>();
            itemView.setTag(viewSparseArray);
        }
        View childView = viewSparseArray.get(id);
        if (null == childView) {
            childView = itemView.findViewById(id);
            viewSparseArray.put(id, childView);
        }
        return (T) childView;
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public RelativeLayout getRelativeLayout(int id) {
        return getView(id);
    }

    public LinearLayout getLinearLayout(int id) {
        return getView(id);
    }

    public FrameLayout getFrameLayout(int id) {
        return getView(id);
    }

    public Button getButton(int id) {
        return getView(id);
    }

    public void setButtonText(int id, String text) {
        getButton(id).setText(text);
    }

    public void setButtonColor(int id, int color) {
        getButton(id).setTextColor(ContextCompat.getColor(getContext(), color));
    }

    public RadioButton getRadioButton(int id) {
        return getView(id);
    }

    public CheckBox getCheckBox(int id) {
        return getView(id);
    }

    public ProgressBar getProgressBar(int id) {
        return getView(id);
    }

    public SeekBar getSeekBar(int id) {
        return getView(id);
    }

    public RatingBar getRatingBar(int id) {
        return getView(id);
    }

    public GridLayout getGridLayout(int id) {
        return getView(id);
    }

    public RadioGroup getRadioGroup(int id) {
        return getView(id);
    }

    public ImageView getImageView(int id) {
        return getView(id);
    }

    public TextView getTextView(int id) {
        return getView(id);
    }

    public void setTextView(int id, CharSequence charSequence) {
        getTextView(id).setText(charSequence);
    }

    public void setTextColor(int id, int color) {
        getTextView(id).setTextColor(ContextCompat.getColor(getContext(), color));
    }

    public void setTextSize(int id, float size) {
        getTextView(id).setTextSize(size);
    }
}
