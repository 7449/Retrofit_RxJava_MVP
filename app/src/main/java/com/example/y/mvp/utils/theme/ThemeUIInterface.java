package com.example.y.mvp.utils.theme;

import android.content.res.Resources;
import android.view.View;

/**
 * by y on 2016/6/16.
 */
public interface ThemeUIInterface {
    View getView();

    void setTheme(Resources.Theme themeId);
}
