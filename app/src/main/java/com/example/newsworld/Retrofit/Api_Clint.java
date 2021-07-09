package com.example.newsworld.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Clint {

    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static Api_Clint client;
    private static Retrofit retrofit;

    private Api_Clint(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

        public static synchronized Api_Clint getInstance(){
        if (client == null){
            client = new Api_Clint();
        }
        return client;
    }


    public Api_Interface getApi() {
        return retrofit.create(Api_Interface.class);
    }
}

