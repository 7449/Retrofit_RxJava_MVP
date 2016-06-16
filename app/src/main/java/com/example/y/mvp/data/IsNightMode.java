package com.example.y.mvp.data;

/**
 * by y on 2016/6/16.
 */
@SuppressWarnings("ALL")
public class IsNightMode {


    public IsNightMode(boolean isNightMode) {
        this.isNightMode = isNightMode;
    }

    public boolean isNightMode() {
        return isNightMode;
    }

    public void setNightMode(boolean nightMode) {
        isNightMode = nightMode;
    }

    private boolean isNightMode = false;

}
