package com.backlayout;


interface SwipeBackActivityBase {
    
    SwipeBackLayout getSwipeBackLayout();

    void setSwipeBackEnable(boolean enable);

    void scrollToFinishActivity();
}
