package com.example.simpkb.Spinner;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpinnerInterface {

    String JSONURL = "http://simpkb.banyumaskab.go.id/android/";
    String JSONKab = "http://simpkb.banyumaskab.go.id/android/";
    String JSONKec = "http://simpkb.banyumaskab.go.id/android/";


    @GET("getprov")
    Call<JsonObject> getData();

    @GET("getkab")
    Call<JsonObject> getKab(
            @Query("id_prov") String id_prov
    );

    @GET("getkec")
    Call<JsonObject> getKec(@Query("id_kab")String id_kab);

    @GET("getkel")
    Call<JsonObject> getkel(@Query("id_kec")String id_kec);



}
