package com.example.simpkb.Nomorantrian.Api;

import com.example.simpkb.Nomorantrian.Model.GetDataantrian;
import com.example.simpkb.Nomorantrian.Model.ResposModelAn;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequestAntrian {
    String JSONURL = "http://simpkb.banyumaskab.go.id/apiandroid/";

    @GET("antrian1")
    Call<JsonObject> antrian();

    @GET("index")
    Call<JsonObject> getimage();


}
