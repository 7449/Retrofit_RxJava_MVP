package com.example.y.mvp.mvp.view;

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
public interface BaseView<T> {


    void setData(List<T> datas);

    void netWorkError();

    /**
     * 需要刷新的继承此View
     *
     * @param <T>
     */
    interface OnRefreshView<T> extends BaseView<T> {
        void hideProgress();

        void showProgress();

        void showFoot();

        void hideFoot();
    }

    interface ImageDetailView extends BaseView<ImageDetailInfo> {
    }

    interface ImageListView extends OnRefreshView<ImageListInfo> {
    }

    interface ImageNewView extends BaseView<ImageNewInfo> {
        void hideProgress();

        void showProgress();

        void offKeyBoard();
    }

    interface NewsListView extends OnRefreshView<NewsListInfo> {
    }

    interface NewsDetailView {
        void setData(NewsDetailInfo datas);

        void netWorkError();

        void hideProgress();

        void showProgress();
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
    }

    interface ToolBarItemView {
        void switchShare();
    }
}
