package com.example.simpkb.Api;

import androidx.constraintlayout.solver.state.ConstraintReference;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Retroserver {

    private static final String baseURL ="http://simpkb.banyumaskab.go.id/android/";

    private static Retrofit retrofit;
//    public static Retrofit getClient

    public static Retrofit konekRetrofit (){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }


//    public static ConstraintReference.ConstraintReferenceFactory detClient() {
//
//    }
}
