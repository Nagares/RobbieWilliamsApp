package com.example.robbiewilliamsapp.tools;

import android.util.Base64;
import android.util.Log;

import com.example.robbiewilliamsapp.models.ClientCredo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SpotifyAuthentication {


    public static void generateToken() {
        Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
        ClientCredo credo = ClientCredo.getInstance();

        String clientId = credo.CLIENT_ID;
        String clientSecret = credo.CLIENT_SECRET;
        String responseBody = null;
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .build();

        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .addHeader("Authorization", "Basic " + Base64.encodeToString((clientId + ":" + clientSecret).getBytes(), Base64.NO_WRAP))
                .post(requestBody)
                .build();

                    Response response = client.newCall(request).execute();

                    if (response.isSuccessful()) {
                        responseBody = response.body().string();
                        Gson gson = new Gson();

                        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);

                        credo.setClientToken("Bearer "+jsonObject.get("access_token").getAsString());


                        Log.d("###",credo.getClientToken());
                    } else {

                        Log.d("###","Error: " + response.code());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();



    }


}