package com.example.y.mvp.utils.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.y.mvp.utils.theme.ThemeUIInterface;
import com.example.y.mvp.utils.theme.ViewAttributeUtils;

/**
 * by y on 2016/6/16.
 */
public class ThemeView extends ImageView implements ThemeUIInterface {

    private int attr_img = -1;

    public ThemeView(Context context) {
        super(context);
    }

    public ThemeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ThemeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        attr_img = ViewAttributeUtils.getSrcAttribute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if (attr_img != -1) {
            ViewAttributeUtils.applyImageDrawable(this, themeId, attr_img);
        }
    }
}

