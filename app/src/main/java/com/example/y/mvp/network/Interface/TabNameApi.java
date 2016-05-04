package com.example.y.mvp.network.Interface;


import com.example.y.mvp.mvp.Bean.TabNameBean;
import com.example.y.mvp.network.Api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * by y on 2016/4/28.
 */
public interface TabNameApi {

    @GET(Api.TAB_NAME)
    Observable<TabNameBean> getTabName();

}
