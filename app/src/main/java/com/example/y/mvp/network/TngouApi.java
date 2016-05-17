package com.example.y.mvp.network;

import com.example.y.mvp.mvp.Bean.ImageDetailBean;
import com.example.y.mvp.mvp.Bean.ImageListBean;
import com.example.y.mvp.mvp.Bean.ImageNewBean;
import com.example.y.mvp.mvp.Bean.NewsDetailBean;
import com.example.y.mvp.mvp.Bean.NewsListBean;
import com.example.y.mvp.mvp.Bean.TabNameBean;
import com.example.y.mvp.mvp.Bean.TabNewsBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by y on 2016/5/17.
 */
public interface TngouApi {


    @GET(Api.TAB_NEWS)
    Observable<TabNewsBean> getTabNews();


    @GET(Api.TAB_NAME)
    Observable<TabNameBean> getTabName();

    @GET(Api.NEWS_LIST)
    Observable<NewsListBean> getNewsList(@Query("id") int id, @Query("page") int page);


    @GET(Api.NEWS_SHOW)
    Observable<NewsDetailBean> getNewsDetail(@Query("id") int id);


    @GET(Api.IMAGE_LIST)
    Observable<ImageListBean> getImageList(@Query("id") int id, @Query("page") int page);


    @GET(Api.IMAGE_NEW)
    Observable<ImageNewBean> getImageNews(@Query("id") int id, @Query("rows") int rows);


    @GET(Api.IMAGE_SHOW)
    Observable<ImageDetailBean> getImageDetail(@Query("id") int id);

}
