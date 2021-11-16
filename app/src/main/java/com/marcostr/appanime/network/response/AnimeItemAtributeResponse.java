package com.marcostr.appanime.network.response;

public class AnimeItemAtributeResponse {

    private String createdAt;

    private String description;

    private String canonicalTitle;

    private String youtubeVideoId;

    private AnimeItemAtributeCoverImage posterImage;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCanonicalTitle() {
        return canonicalTitle;
    }

    public void setCanonicalTitle(String canonicalTitle) {
        this.canonicalTitle = canonicalTitle;
    }

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }

    public AnimeItemAtributeCoverImage getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(AnimeItemAtributeCoverImage posterImage) {
        this.posterImage = posterImage;
    }
}
