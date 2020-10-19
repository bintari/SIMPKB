package com.example.simpkb.booking1.ApiBooking;

import com.example.simpkb.booking1.ModelBooking.ResponseModelBooking;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequestBooking extends Call<ResponseModelBooking> {
    @FormUrlEncoded
    @POST("createnomor.php")
    Call<ApiRequestBooking> getbookingtanpa(
                                            @Field("tanggalbooking") String tanggalbooking,
                                            @Field("nomorkendaraan") String nomorkendaraan,
                                            @Field("spjenispelayanan") String spjenispelayanan);

}
