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

    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static TngouApi getTngouApi() {
        if (tngouApi == null) {
            tngouApi = getRetrofit().create(TngouApi.class);
        }
        return tngouApi;
    }


    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(Api.BASE_API)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

}
