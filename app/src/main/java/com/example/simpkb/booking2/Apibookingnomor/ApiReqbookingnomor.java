package com.example.simpkb.booking2.Apibookingnomor;

import com.example.simpkb.booking2.modelbookingnomor.ResponseModelBookingnomor;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiReqbookingnomor {
    @FormUrlEncoded
    @POST("createnomor.php")
    Call<ResponseModelBookingnomor> getbookingnomor(@Field("noujian") String noujian,
                                               @Field("platnomor") String platnomor);

}
