package com.example.y.mvp.mvp.view;

import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * by y on 2016/5/27.
 */
public interface BaseView<T> {


    void setData(List<T> datas);

    void netWorkError();

    void hideProgress();

    void showProgress();

    void showFoot();

    void hideFoot();


    interface ImageDetailView extends BaseView<ImageDetailInfo> {
    }

    interface ImageListView extends BaseView<ImageListInfo> {
    }

    interface ImageNewView extends BaseView<ImageNewInfo> {
    }

    interface NewsListView extends BaseView<NewsListInfo> {
    }

    interface TabNameView extends BaseView<TabNameInfo> {
    }

    interface TabNewsView extends BaseView<TabNewsInfo> {
    }

    interface MainView {


        void switchNews();

        void switchImageClassification();

        void switchNewImage();

        void switchAbout();

        void switchTest();

    }
}
