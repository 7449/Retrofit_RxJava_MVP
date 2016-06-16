package com.example.y.mvp.utils.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.y.mvp.utils.theme.ThemeUIInterface;
import com.example.y.mvp.utils.theme.ViewAttributeUtils;

/**
 * by y on 2016/6/16.
 */
public class ThemeButton extends Button implements ThemeUIInterface {

    private int attr_drawable = -1;
    private int attr_textColor = -1;

    public ThemeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public ThemeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ThemeButton(Context context) {
        super(context);
        init(null);
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
