package com.marcostr.appanime.network.response;

public class AnimeItemResponse {

    private int id;

    private AnimeItemAtributeResponse attributes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnimeItemAtributeResponse getAttributes() {
        return attributes;
    }

    public void setAttributes(AnimeItemAtributeResponse attributes) {
        this.attributes = attributes;
    }
}
