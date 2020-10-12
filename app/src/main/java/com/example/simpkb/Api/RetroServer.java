package com.example.simpkb.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String baseURL ="http://192.168.43.85/magang/m2/";
    private static final String baseURL2= "https://gendisdesa.heraya.web.id/";

    private static Retrofit retrofit;
//    public static Retrofit getClient

    public static Retrofit konekRetrofit (){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static Retrofit konekRetrofit2 (){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
