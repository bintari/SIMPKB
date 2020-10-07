package com.example.simpkb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    //trahir
//    @GET("posts")
//    Call<List<Post>> getPost();

    @GET("antrian1")
    Call<List<Post>> getPost();


}
