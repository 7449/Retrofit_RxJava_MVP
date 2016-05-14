package com.example.y.mvp.network.Interface;

import com.example.y.mvp.mvp.Bean.TabNewsBean;
import com.example.y.mvp.network.Api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * by 12406 on 2016/5/14.
 */
public interface TabNewsApi {

    @GET(Api.TAB_NEWS)
    Observable<TabNewsBean> getTabNews();

}
