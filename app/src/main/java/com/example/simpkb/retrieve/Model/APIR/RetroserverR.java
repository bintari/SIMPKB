package com.example.simpkb.retrieve.Model.APIR;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroserverR {
    private static final String BASE_URL = "http://simpkb.banyumaskab.go.id/apiandroid/antrian1/";

    public static Retrofit retrofit;

    public static Retrofit konekreto(){
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
}
