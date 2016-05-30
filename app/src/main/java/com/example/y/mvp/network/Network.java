package com.example.y.mvp.network;


import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * by y on 2016/4/28.
 */
class Network {


    private static TngouApi tngouApi;
    private static BaiDuApi baiDuApi;

    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static TngouApi getTngouApi() {
        if (tngouApi == null) {
            tngouApi = getRetrofit(Api.BASE_API_TNGOU).create(TngouApi.class);
        }
        return tngouApi;
    }

    public static BaiDuApi getBaiDuApi() {
        if (baiDuApi == null) {
            baiDuApi = getRetrofit(Api.BASE_API_BAIDU).create(BaiDuApi.class);
        }
        return baiDuApi;
    }

    private static Retrofit getRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

}
