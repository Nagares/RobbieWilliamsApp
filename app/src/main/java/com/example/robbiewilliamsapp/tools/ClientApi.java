package com.example.robbiewilliamsapp.tools;



import com.example.robbiewilliamsapp.models.ArtistAllInfo;
import com.example.robbiewilliamsapp.models.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ClientApi {
    public static final String BASE_URL = "https://api.spotify.com/";

    @GET("/v1/artists/2HcwFjNelS49kFbfvMxQYw")
    public Call<ArtistAllInfo> getArtist(@Header("Authorization") String authorizationHeader);

    @GET("/v1/artists/2HcwFjNelS49kFbfvMxQYw/top-tracks?market=es")
    public Call<Root> getArtistMusic(@Header("Authorization") String authorizationHeader);
//    @GET("/v/artists/2HcwFjNelS49kFbfvMxQYw/")
//    Call<ResponseBody> getRawJsonData(@Header("Authorization") String authorizationHeader);



}