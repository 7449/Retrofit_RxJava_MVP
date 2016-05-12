package com.example.y.mvp.network;


import com.example.y.mvp.network.Interface.EncyclopediaApi;
import com.example.y.mvp.network.Interface.ImageDetailApi;
import com.example.y.mvp.network.Interface.ImageListApi;
import com.example.y.mvp.network.Interface.ImageNewApi;
import com.example.y.mvp.network.Interface.TabNameApi;

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

    private static TabNameApi tabNameApi;
    private static ImageListApi imageListApi;
    private static ImageNewApi imageNewApi;
    private static ImageDetailApi imageDetailApi;
    private static EncyclopediaApi encyclopediaApi;

    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static EncyclopediaApi getEncyclopediaApi() {
        if (encyclopediaApi == null) {
            encyclopediaApi = getRetrofit().create(EncyclopediaApi.class);
        }
        return encyclopediaApi;
    }


    public static TabNameApi getTabNameApi() {
        if (tabNameApi == null) {
            tabNameApi = getRetrofit().create(TabNameApi.class);
        }
        return tabNameApi;
    }

    public static ImageListApi getImageListApi() {
        if (imageListApi == null) {
            imageListApi = getRetrofit().create(ImageListApi.class);
        }
        return imageListApi;
    }

    public static ImageNewApi getImageNewApi() {
        if (imageNewApi == null) {
            imageNewApi = getRetrofit().create(ImageNewApi.class);
        }
        return imageNewApi;
    }

    public static ImageDetailApi getImageDetailApi() {
        if (imageDetailApi == null) {
            imageDetailApi = getRetrofit().create(ImageDetailApi.class);
        }
        return imageDetailApi;
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
