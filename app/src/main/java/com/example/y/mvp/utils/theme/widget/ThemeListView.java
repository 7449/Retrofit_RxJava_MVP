package com.example.y.mvp.utils.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.example.y.mvp.utils.theme.ThemeUIInterface;
import com.example.y.mvp.utils.theme.ViewAttributeUtils;

/**
 * by 12406 on 2016/6/17.
 */
public class ThemeListView extends ListView implements ThemeUIInterface {

    private int attr_background = -1;

    public ThemeListView(Context context) {
        super(context);
    }

    public ThemeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ThemeListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        attr_background = ViewAttributeUtils.getBackgroundAttibute(attrs);
    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if (attr_background != -1) {
            ViewAttributeUtils.applyBackgroundDrawable(this, themeId, attr_background);
        }
    }
}
