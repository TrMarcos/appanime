package com.marcostr.appanime.network.response;

public class AnimeItemAtributeResponse {

    private String createdAt;

    private String description;

    private String canonicalTitle;

    private String youtubeVideoId;

    private AnimeItemAtributeCoverImage coverImage;

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

    public AnimeItemAtributeCoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(AnimeItemAtributeCoverImage coverImage) {
        this.coverImage = coverImage;
    }
}
