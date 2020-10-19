package com.example.simpkb.booking1.ApiBooking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServerAntrian {
    public static final String URL = "http:// 192.168.43.85/magang/booking/";
    private Retrofit retrofit;

    public static Retrofit getretro() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        return retrofit;
    }
}
