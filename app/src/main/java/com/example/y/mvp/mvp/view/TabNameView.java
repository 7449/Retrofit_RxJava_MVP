package com.example.y.mvp.mvp.view;


import com.example.y.mvp.mvp.Bean.TabNameInfo;

import java.util.List;

/**
 * by y on 2016/4/28.
 */
public interface TabNameView {

    void addTabName(List<TabNameInfo> tabNameInfo);

    void netWorkError();

}
