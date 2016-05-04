package com.example.y.mvp.mvp.view;


import com.example.y.mvp.mvp.Bean.ImageDetailInfo;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public interface ImageDetailView {

    void setImageDetailInfo(List<ImageDetailInfo> imageDetailInfo);

    void netWorkError();

}
