package com.example.simpkb.Api;

import com.example.simpkb.Models.LoginModel;
import com.example.simpkb.Models.ResponseModel;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIRequestData {
    @GET("read.php")
    Call<ResponseModel> ardRetriveData();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateData(
            @Field("nik") String nik,
            @Field("nama") String nama,
            @Field("provinsi") String provinsi,
            @Field("kabupaten") String kabupaten,
            @Field("kecamatan") String kecamatan,
            @Field("desa") String desa,
            @Field("rt") String rt,
            @Field("rw") String rw,
            @Field("nohp") String nohp,
            @Field("password") String password
            );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> ardDeleteData(
            @Field("nik") int nik
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> ardUpdateData(
            @Field("nik") String nik,
            @Field("password") String password
    );


    //login
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("nik") String nik,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API http://192.168.88.20/latihan1/register.php

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nik") String nik,
                                       @Field("nama") String nama,
                                       @Field("provinsi") String provinsi,
                                       @Field("kabupaten") String kabupaten,
                                       @Field("kecamatan") String kecamatan,
                                       @Field("desa") String desa,
                                       @Field("rt") String rt,
                                       @Field("rw") String rw,
                                       @Field("nohp") String nohp,
                                       @Field("password") String password
    );
//    @POST("/auth")
//    Call<ResponseModel> userLogin(@Body final LoginModel body);

    @GET("/auth")
    Call<ResponseModel> userLogin(@Query("body") LoginModel  body);
}
