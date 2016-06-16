package com.example.y.mvp.utils.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.View;

import com.example.y.mvp.utils.theme.ThemeUIInterface;
import com.example.y.mvp.utils.theme.ViewAttributeUtils;

/**
 * by 12406 on 2016/6/17.
 */
public class ThemeDrawerLayout extends DrawerLayout implements ThemeUIInterface {

    private int attr_drawable = -1;

    public ThemeDrawerLayout(Context context) {
        super(context);
    }

    public ThemeDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ThemeDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        attr_drawable = ViewAttributeUtils.getBackgroundAttibute(attrs);
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
    }
}
