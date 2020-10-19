package com.example.simpkb.LOGIN;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface userService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> userLogin(@Field("username") String Username,
                                  @Field("password") String Password);

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registrasi(@Field("nik") String nik,
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






}

