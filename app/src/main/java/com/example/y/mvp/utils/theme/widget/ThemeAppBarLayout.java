package com.example.y.mvp.utils.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;
import android.view.View;

import com.example.y.mvp.utils.theme.ThemeUIInterface;
import com.example.y.mvp.utils.theme.ViewAttributeUtils;

/**
 * by 12406 on 2016/6/17.
 */
public class ThemeAppBarLayout extends AppBarLayout implements ThemeUIInterface {

    private int attr_drawable = -1;

    public ThemeAppBarLayout(Context context) {
        super(context);
    }

    public ThemeAppBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
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
