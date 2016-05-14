package com.example.y.mvp.network;


import com.example.y.mvp.network.Interface.EncyclopediaApi;
import com.example.y.mvp.network.Interface.ImageDetailApi;
import com.example.y.mvp.network.Interface.ImageListApi;
import com.example.y.mvp.network.Interface.ImageNewApi;
import com.example.y.mvp.network.Interface.NewsDetailApi;
import com.example.y.mvp.network.Interface.NewsListApi;
import com.example.y.mvp.network.Interface.TabNameApi;
import com.example.y.mvp.network.Interface.TabNewsApi;

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
    private static TabNewsApi tabNewsApi;
    private static NewsListApi newsListApi;
    private static NewsDetailApi newsDetailApil;

    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static NewsDetailApi getNewsDetailApil() {
        if (newsDetailApil == null) {
            newsDetailApil = getRetrofit().create(NewsDetailApi.class);
        }
        return newsDetailApil;
    }

    public static NewsListApi getNewsListApi() {
        if (newsListApi == null) {
            newsListApi = getRetrofit().create(NewsListApi.class);
        }
        return newsListApi;
    }

    public static TabNewsApi getTabNewsApi() {
        if (tabNewsApi == null) {
            tabNewsApi = getRetrofit().create(TabNewsApi.class);
        }
        return tabNewsApi;
    }

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
