package com.example.simpkb.Spinner;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpinnerInterface {

    String JSONURL = "http://simpkb.banyumaskab.go.id/android/";

    @GET("getprov")
    Call<JsonObject> getData();
}
