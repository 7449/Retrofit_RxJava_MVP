package com.example.y.mvp.network.Interface;


import com.example.y.mvp.mvp.Bean.ImageListBean;
import com.example.y.mvp.network.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by y on 2016/4/28.
 */
public interface ImageListApi {


    @GET(Api.IMAGE_LIST + "?id" + "id" + "id" + "&" + "page" + "page")
    Observable<ImageListBean> getImageList(@Query("id") int id, @Query("page") int page);


}
