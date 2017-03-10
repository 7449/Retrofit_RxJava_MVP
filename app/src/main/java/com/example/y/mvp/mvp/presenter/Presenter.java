package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.model.ImageListInfo;
import com.example.y.mvp.mvp.model.ImageNewInfo;
import com.example.y.mvp.mvp.model.NewsListInfo;

/**
 * by y on 2016/5/27.
 */

public interface Presenter {


    interface ImageDetailPresenter {
        void requestNetWork(int id);

        void competence(int requestCode, int[] grantResults);
    }

    interface ImageListPresenter {
        void requestNetWork(int id, int page);

        void onClick(ImageListInfo info);
    }

    interface ImageNewPresenter {
        void requestNetWork(String id, String rows);

        void onClick(ImageNewInfo info);
    }

    interface MainViewPresenter {
        void switchPosition(int position);
    }

    interface ToolBarItemPresenter {
        void switchId(int id);
    }


    interface NewsListPresenter {
        void requestNetWork(int id, int page);

        void onClick(NewsListInfo info);
    }

    interface NewsDetailPresenter {
        void requestNetWork(int id);
    }

    interface TabNamePresenter {
        void requestNetWork();
    }

    interface TabNewsPresenter {
        void requestNetWork();
    }
}
