package com.example.y.mvp.network.Interface;


import com.example.y.mvp.mvp.Bean.ImageDetailBean;
import com.example.y.mvp.network.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by y on 2016/4/29.
 */
public interface ImageDetailApi {

    @GET(Api.IMAGE_SHOW)
    Observable<ImageDetailBean> getImageDetail(@Query("id") int id);
}
