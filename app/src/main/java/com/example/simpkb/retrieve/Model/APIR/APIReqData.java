package com.example.simpkb.retrieve.Model.APIR;

import com.example.simpkb.retrieve.Model.ResponseModelR;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface APIReqData {
    @FormUrlEncoded
    @GET("retrieve.php")
    Call<ResponseModelR> ARdRetrievedata();


}
