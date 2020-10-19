package com.example.simpkb.Api;

import com.example.simpkb.Models.ResponseModelReg;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequestReg {


    @FormUrlEncoded
    @POST("register")
    public Call<ResponseModelReg> sendReg (@Field("nik") String  nik,
                                           @Field("nama") String nama,
                                           @Field("email") String email,
                                           @Field("notelp") String notelp,
                                           @Field("alamat") String alamat,
                                           @Field("password") String password,
                                           @Field("kode_verifikasi") String kode_verifikasi,
                                           @Field("status") String status,
                                           @Field("token") String token,
                                           @Field("kodelink") String kodelink,
                                           @Field("role") String role,
                                           @Field("rt") String rt,
                                           @Field("rw") String rw,
                                           @Field("kelurahan") String kelurahan,
                                           @Field("id") String id,
                                           @Field("count_sms_verif_ul") String count_sms_verif_ul,
                                           @Field("status_sms") String status_sms,
                                           @Field("time_send") String time_send,
                                           @Field("tgldaftar") String tgldaftar



    );


}
