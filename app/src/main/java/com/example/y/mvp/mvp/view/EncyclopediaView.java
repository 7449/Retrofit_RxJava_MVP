package com.example.y.mvp.mvp.view;


import com.example.y.mvp.mvp.Bean.EncyclopediaInfo;

import java.util.List;

/**
 * by y on 2016/4/28.
 */
public interface EncyclopediaView {

    void setEncyclopedia(List<EncyclopediaInfo> encyclopediaInfo);

    void netWorkError();

    void hideProgress();

    void showFoot();

    void hideFoot();

    
}
