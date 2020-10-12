package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simpkb.Api.APIRequestData;
import com.example.simpkb.Api.ApiService;
import com.example.simpkb.Api.RetroServer;
import com.example.simpkb.LOGIN.ApiClient;
import com.example.simpkb.LOGIN.LoginRequest;
import com.example.simpkb.LOGIN.LoginResponse;
import com.example.simpkb.Models.LoginModel;
import com.example.simpkb.Models.ResponseModel;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    Button bt;
    EditText username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.lognik);
        password = findViewById(R.id.logpass);

        bt = findViewById(R.id.login);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        if(TextUtils.isEmpty(username.getText().toString())||TextUtils.isEmpty(password.getText().toString())){
                            Toast.makeText(Login.this, "Username/Password Required", Toast.LENGTH_LONG).show();
                        }else{
                            login();
                        }

            }
        });



    }

    private void login() {
        LoginRequest loginRequest = new LoginRequest();

        String Username = (username.getText().toString());
        String Password = (password.getText().toString());
        Call<LoginResponse> loginResponseCall = ApiClient.getuserService().userLogin(Username,Password);


        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, final Response<LoginResponse> response) {
                System.out.println("suksess"+response.body().getStatus());
                if (response.isSuccessful()){
                    Toast.makeText(Login.this, "login sukses", Toast.LENGTH_SHORT).show();
                    LoginResponse loginResponse = response.body();
                    System.out.println("loginini"+response.toString());

                    if (loginResponse.getStatus()==1){
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                LoginResponse loginResponse = response.body();
                                assert loginResponse != null;
                                startActivity(new Intent(Login.this, dashboard.class).putExtra("data", loginResponse.getData().getNama()));
                            }
                        }, 300);
                    }else{
                        Toast.makeText(Login.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(Login.this, "login gagal", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "trobel"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}

