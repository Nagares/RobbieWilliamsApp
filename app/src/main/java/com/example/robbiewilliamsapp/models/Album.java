package com.example.robbiewilliamsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album{
    @SerializedName("album_type")
    @Expose
    String album_type;
    @SerializedName("artists")
    @Expose
    List<Artist> artists;
    @SerializedName("external_urls")
    @Expose
    ExternalUrls external_urls;
    @SerializedName("href")
    @Expose
    String href;
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("images")
    @Expose
    List<Image> images;
    @SerializedName("is_playable")
    @Expose
    boolean is_playable;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("release_date")
    @Expose
    String release_date;
    @SerializedName("release_date_precision")
    @Expose
    String release_date_precision;
    @SerializedName("total_tracks")
    @Expose
    int total_tracks;
    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("uri")
    @Expose
    String uri;

    public String getAlbum_type() {
        return album_type;
    }

    public void setAlbum_type(String album_type) {
        this.album_type = album_type;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public ExternalUrls getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(ExternalUrls external_urls) {
        this.external_urls = external_urls;
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

    public boolean isIs_playable() {
        return is_playable;
    }

    public void setIs_playable(boolean is_playable) {
        this.is_playable = is_playable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRelease_date_precision() {
        return release_date_precision;
    }

    public void setRelease_date_precision(String release_date_precision) {
        this.release_date_precision = release_date_precision;
    }

    public int getTotal_tracks() {
        return total_tracks;
    }

    public void setTotal_tracks(int total_tracks) {
        this.total_tracks = total_tracks;
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