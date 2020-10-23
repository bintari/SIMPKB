package com.example.simpkb.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simpkb.Api.ApiClient;
import com.example.simpkb.LOGIN.LoginRequest;
import com.example.simpkb.LOGIN.LoginResponse;
import com.example.simpkb.LOGIN.UserModel;
import com.example.simpkb.LOGIN.Util.SharedPrev;
import com.example.simpkb.R;

import java.util.prefs.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button bt;
    EditText username, password;

    Context context;

    SharedPrev sharedPrev;


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
        final Call<LoginResponse> loginResponseCall = ApiClient.getuserService().userLogin(Username,Password);


        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, final Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(Login.this, "login sukses", Toast.LENGTH_SHORT).show();
                    LoginResponse loginResponse = response.body();

                    if (loginResponse.getStatus()==1){
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                 LoginResponse loginResponse = response.body();
                                UserModel userModel = loginResponse.getData();
                                SharedPrev.setLoggedInStatus(getBaseContext(),1);
                                SharedPrev.setUsernameLog(getBaseContext(),userModel.getNik());
                                SharedPrev.setNama(getBaseContext(),userModel.getNama());
                                SharedPrev.setNoTelepon(getBaseContext(),userModel.getNotelp());
                                SharedPrev.setalamat(getBaseContext(),userModel.getNotelp());

                                System.out.println("bintari : "+SharedPrev.getLoggedInStatus(getBaseContext()));
                                System.out.println("bintari username: "+SharedPrev.getUsernameLog(getBaseContext()));
                                System.out.println("bintari nama: "+SharedPrev.getNama(getBaseContext()));
                                System.out.println("bintari nomor: "+SharedPrev.getNoTelepon(getBaseContext()));
//                                assert loginResponse != null;
//                                startActivity(new Intent(Login.this, dashboard.class));
                                startActivity(new Intent(getBaseContext(),dashboard.class));
                                finish();
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

