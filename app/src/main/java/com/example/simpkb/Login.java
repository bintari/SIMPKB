package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simpkb.Api.APIRequestData;
import com.example.simpkb.Api.ApiService;
import com.example.simpkb.Api.RetroServer;
import com.example.simpkb.Models.LoginModel;
import com.example.simpkb.Models.ResponseModel;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    Button bt;
    EditText lognik, logpass;

    ProgressDialog loading;

    Context mContext;
    ApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lognik = findViewById(R.id.lognik);
        logpass = findViewById(R.id.logpass);

        bt = findViewById(R.id.login);



    }


    private void userSignIn(){
        String nik = lognik.getText().toString().trim();
        String password = logpass.getText().toString().trim();
        APIRequestData ardData = RetroServer.konekRetrofit2().create(APIRequestData.class);

//        Map<String, Object> jsonParams = new ArrayMap<>();
////put something inside the map, could be null
//        jsonParams.put("nik", nik);
//        jsonParams.put("password", password);
//
//
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());
////serviceCaller is the interface initialized with retrofit.create...
        LoginModel body = new LoginModel(nik,password);

        Call<ResponseModel> simpanData = ardData.userLogin(body);

        simpanData.enqueue(new Callback<ResponseModel>() {
                               @Override
                               public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                                   Toast.makeText(mContext, "berhasil", Toast.LENGTH_SHORT).show();

                               }

                               @Override
                               public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                               }
                           });
//            @Override
//            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                    finish();
//                    Toast.makeText(mContext, "berhasil", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
//                }
//            });
//            @Override
//            public void onFailure(Call<ResponseModel> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });


    }


    public void onClick(View view) {
            userSignIn();
    }
}

