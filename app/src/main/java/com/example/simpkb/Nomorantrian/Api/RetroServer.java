package com.example.simpkb.Nomorantrian.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    public static final String URL = "http://simpkb.banyumaskab.go.id/apiandroid/";

    private Retrofit retrofit;

    public static Retrofit koneksiantrian(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        return retrofit;
    }
}
