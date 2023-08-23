package com.example.robbiewilliamsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistAllInfo {

    @SerializedName("external_urls")
    @Expose
        ExternalUrls external_urls;
    @SerializedName("followers")
    @Expose
        Followers followers;
    @SerializedName("genres")
    @Expose
        List<String> genres;
    @SerializedName("href")
    @Expose
        String href;
    @SerializedName("id")
    @Expose
        String id;

    @SerializedName("images")
    @Expose
    List<Image> images;
    @SerializedName("name")
    @Expose
        String name;
    @SerializedName("popularity")
    @Expose
        int popularity;
    @SerializedName("type")
    @Expose
        String type;
    @SerializedName("uri")
    @Expose
        String uri;

    public ExternalUrls getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(ExternalUrls external_urls) {
        this.external_urls = external_urls;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}


