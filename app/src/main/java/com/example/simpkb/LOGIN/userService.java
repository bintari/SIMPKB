package com.example.simpkb.LOGIN;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface userService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> userLogin(@Field("username") String Username,@Field("password") String Password);


}

