package com.example.y.mvp.mvp.view;


import com.example.y.mvp.mvp.Bean.ImageNewInfo;

import java.util.List;

/**
 * by y on 2016/4/28.
 */
public interface ImageNewView {

    void setImageNewInfo(List<ImageNewInfo> imageNewInfo);

    void netWorkError();

    void hideProgress();
    
    void showProgress();

}
