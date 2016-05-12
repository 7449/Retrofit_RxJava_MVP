package com.example.y.mvp.network.Interface;

import com.example.y.mvp.mvp.Bean.EncyclopediaBean;
import com.example.y.mvp.network.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by y on 2016/5/11.
 */
public interface EncyclopediaApi {

    @GET(Api.ENCYCLOPEDIA_API)
    Observable<EncyclopediaBean> getEncyclopedia(@Query("keyword") String keyword, @Query("page") int page);


}
