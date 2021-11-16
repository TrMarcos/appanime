package com.marcostr.appanime.network.response;

import com.marcostr.appanime.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeListResponse {

    private List<AnimeItemResponse> data;

    public List<AnimeItemResponse> getAnimeList() {
        return data;
    }

    public void setAnimeList(List<AnimeItemResponse> animeList) {
        this.data = animeList;
    }

    public List<Anime> parseAnimeList () {

        List<Anime> result = new ArrayList<Anime>();
        for( AnimeItemResponse itemResponse : this.data ){

            Anime item = new Anime();
            item.setTitle(itemResponse.getAttributes().getCanonicalTitle());
            item.setCreatedAt(itemResponse.getAttributes().getCreatedAt());
            item.setDescription(itemResponse.getAttributes().getDescription());
            item.setYoutubeVideoId(itemResponse.getAttributes().getYoutubeVideoId());
            if(itemResponse.getAttributes().getPosterImage() != null) {
                item.setImage(itemResponse.getAttributes().getPosterImage().getOriginal());
            }

                result.add(item);
        }

        return result;
    }
}
