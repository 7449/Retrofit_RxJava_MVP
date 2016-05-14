package com.example.y.mvp.network.Interface;

import com.example.y.mvp.mvp.Bean.NewsListBean;
import com.example.y.mvp.network.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by 12406 on 2016/5/15.
 */
public interface NewsListApi {

    @GET(Api.NEWS_LIST)
    Observable<NewsListBean> getNewsList(@Query("id") int id, @Query("page") int page);

}
