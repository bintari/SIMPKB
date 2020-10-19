package com.example.simpkb.booking2.Apibookingnomor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServerbokingnomor {
    public static final String URL = "http://192.168.43.85/magang/booking/";
    private Retrofit retrofit;



    public static Retrofit getbooking() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(URL)
                .build();

        return retrofit;
    }
}
