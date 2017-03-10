package com.example.y.mvp.network;


import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.model.NewsDetailInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by y on 2016/5/17.
 */
public interface TngouApi {


    @GET(Api.TAB_NEWS)
    Observable<BaseBean.TabNewsBean> getTabNews();


    @GET(Api.TAB_NAME)
    Observable<BaseBean.TabNameBean> getTabName();

    @GET(Api.NEWS_LIST)
    Observable<BaseBean.NewsListBean> getNewsList(@Query("id") int id, @Query("page") int page);


    @GET(Api.NEWS_SHOW)
    Observable<NewsDetailInfo> getNewsDetail(@Query("id") int id);


    @GET(Api.IMAGE_LIST)
    Observable<BaseBean.ImageListBean> getImageList(@Query("id") int id, @Query("page") int page);


    @GET(Api.IMAGE_NEW)
    Observable<BaseBean.ImageNewBean> getImageNews(@Query("id") int id, @Query("rows") int rows);


    @GET(Api.IMAGE_SHOW)
    Observable<BaseBean.ImageDetailBean> getImageDetail(@Query("id") int id);


}
