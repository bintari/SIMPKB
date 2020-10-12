package com.example.simpkb.model;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterApi {

    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar(@Field("nik") String nik,
                       @Field("nama") String nama,
                       @Field("provinsi") String provinsi,
                       @Field("kabupaten") String kabupaten,
                       @Field("desa") String desa,
                       @Field("rt") String rt,
                       @Field("rw") String rw,
                       @Field("nohp") String nohp,
                       @Field("password") String password
                       );

}