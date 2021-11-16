package com.marcostr.appanime.network.service;

import com.marcostr.appanime.network.response.AnimeListResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface AnimeServices {


    @GET("anime")
    Single<AnimeListResponse> getAnimeList();


}
