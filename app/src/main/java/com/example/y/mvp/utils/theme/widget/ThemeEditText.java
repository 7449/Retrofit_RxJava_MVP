package com.example.y.mvp.utils.theme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.example.y.mvp.utils.theme.ThemeUIInterface;
import com.example.y.mvp.utils.theme.ViewAttributeUtils;

/**
 * by y on 2016/6/16.
 */
public class ThemeEditText extends EditText implements ThemeUIInterface {

    private int attr_background = -1;
    private int attr_textApperance = -1;

    public ThemeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public ThemeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ThemeEditText(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        attr_background = ViewAttributeUtils.getBackgroundAttibute(attrs);
        attr_textApperance = ViewAttributeUtils.getTextApperanceAttribute(attrs);
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
        if (attr_textApperance != -1) {
            ViewAttributeUtils.applyTextAppearance(this, themeId, attr_textApperance);
        }
    }
}
