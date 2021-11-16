package com.marcostr.appanime.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URL = "https://kitsu.io/api/edge/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient (){

     if(retrofit == null){
         HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

         OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                 .addInterceptor(httpLoggingInterceptor)
                 .build();

         retrofit = new Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .client(okHttpClient)
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

     }
      return retrofit;
    }

}
