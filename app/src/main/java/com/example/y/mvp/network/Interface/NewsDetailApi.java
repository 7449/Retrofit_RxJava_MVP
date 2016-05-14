package com.example.y.mvp.network.Interface;

import com.example.y.mvp.mvp.Bean.NewsDetailBean;
import com.example.y.mvp.network.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by 12406 on 2016/5/15.
 */
public interface NewsDetailApi {


    @GET(Api.NEWS_SHOW)
    Observable<NewsDetailBean> getNewsDetail(@Query("id") int id);

}
