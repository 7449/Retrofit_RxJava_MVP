package com.example.y.mvp.mvp.view;

import com.example.y.mvp.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public interface TabNewsView {

    void addTabName(List<TabNewsInfo> tabNewsInfo);

    void netWorkError();

}
