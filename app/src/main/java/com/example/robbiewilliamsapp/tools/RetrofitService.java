package com.example.robbiewilliamsapp.tools;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    //Step 1 to create Singleton - create a static field (instance)
    private static RetrofitService instance = null;
    private ClientApi clientApi = null;

    //Step 2 to create Singleton - make ctor private
    private RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ClientApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        clientApi = retrofit.create(ClientApi.class);
    }

    //Step 3 to create Singleton - create a public factory method
    public static RetrofitService getInstance(){
        if(instance == null){
            instance = new RetrofitService();
        }
        return instance;
    }

    public ClientApi getClientApi(){
        return clientApi;
    }
}
