package com.example.y.mvp.utils.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.example.y.mvp.utils.theme.ThemeUIInterface;
import com.example.y.mvp.utils.theme.ViewAttributeUtils;

/**
 * by y on 2016/6/16.
 */
public class ThemeToolbar extends Toolbar implements ThemeUIInterface {

    private int attr_drawable = -1;
    private int attr_textColor = -1;

    public ThemeToolbar(Context context) {
        super(context);
    }

    public ThemeToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ThemeToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        attr_drawable = ViewAttributeUtils.getBackgroundAttibute(attrs);
        attr_textColor = ViewAttributeUtils.getTextColorAttribute(attrs);
    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if (attr_drawable != -1) {
            ViewAttributeUtils.applyBackgroundDrawable(this, themeId, attr_drawable);
        }
        if (attr_textColor != -1) {
            ViewAttributeUtils.applyTextColor(this, themeId, attr_textColor);
        }
    }
}
