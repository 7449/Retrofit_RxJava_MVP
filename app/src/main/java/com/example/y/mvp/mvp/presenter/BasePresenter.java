package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;

/**
 * by y on 2016/5/27.
 */
@SuppressWarnings("ALL")
public interface BasePresenter {


    interface ImageDetailPresenter {
        void requestNetWork(int id);

        void competence(int requestCode, int[] grantResults);
    }

    interface ImageListPresenter {
        void requestNetWork(int id, int page, boolean isNull);

        void onClick(ImageListInfo info);
    }

    interface ImageNewPresenter {
        void requestNetWork(String id, String rows);

        void onClick(ImageNewInfo info);
    }

    interface MainViewPresenter {
        void switchId(int id);
    }

    interface NewsListPresenter {
        void requestNetWork(int id, int page, boolean isNull);
    }

    interface TabNamePresenter {
        void requestNetWork();
    }

    interface TabNewsPresenter {
        void requestNetWork();
    }


}
