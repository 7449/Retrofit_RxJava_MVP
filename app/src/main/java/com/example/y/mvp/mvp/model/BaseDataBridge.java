package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * by y on 2016/5/27.
 */
public interface BaseDataBridge<T> {

    void addData(List<T> datas);

    void error();


    interface ImageDetailData extends BaseDataBridge<ImageDetailInfo> {
    }

    interface ImageListData extends BaseDataBridge<ImageListInfo> {
    }

    interface ImageNewData extends BaseDataBridge<ImageNewInfo> {
    }

    interface NewsListData extends BaseDataBridge<NewsListInfo> {
    }

    interface NewsDetailData {
        void addData(NewsDetailInfo datas);

        void error();
    }

    interface TabNewsData extends BaseDataBridge<TabNewsInfo> {
    }

    interface TabNameData extends BaseDataBridge<TabNameInfo> {
    }
}
