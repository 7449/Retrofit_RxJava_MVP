package com.example.y.mvp.network.Interface;


import com.example.y.mvp.mvp.Bean.ImageNewBean;
import com.example.y.mvp.network.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by 12406 on 2016/4/29.
 */
public interface ImageNewApi {

    @GET(Api.IMAGE_NEW + "?id" + "id" + "id" + "&" + "rows" + "rows")
    Observable<ImageNewBean> getImageNews(@Query("id") int id, @Query("rows") int rows);

}
