package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simpkb.LOGIN.Util.SharedPrev;
import com.example.simpkb.Nomorantrian.Api.ApiRequestAntrian;
import com.example.simpkb.Nomorantrian.Api.RetroServer;
import com.example.simpkb.Nomorantrian.Model.DataModel;
import com.example.simpkb.Nomorantrian.Model.ResposModelAn;
import com.example.simpkb.R;
import com.google.gson.JsonObject;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

public class MainActivity extends AppCompatActivity {

    String noantrian;
    RelativeLayout a, b, c;
    LinearLayout d;
    ImageView login, lupa;
    TextView nomor;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.banner, R.drawable.banner1, R.drawable.banner2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.layout);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        login = findViewById(R.id.login);
        lupa = findViewById(R.id.lupa);
        nomor = findViewById(R.id.nomorantrian);


        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);


        ApiRequestAntrian apiRequestAntrian = RetroServer.koneksiantrian().create(ApiRequestAntrian.class);
        Call<JsonObject> tampilantrian = apiRequestAntrian.antrian();
        tampilantrian.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                System.out.println("binngepost=="+response.body().getAsJsonObject("data").get("no_antrian"));
                String cetaknama = response.body().getAsJsonObject("data").get("no_antrian").getAsString();
                nomor.setText(cetaknama);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                System.out.println("bingagal=="+t.getLocalizedMessage());

            }
        });

        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, lupapassword.class);
                startActivity(i);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registrasi.class);
                startActivity(intent);

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, verifikasi.class);
                startActivity(intent);

            }
        });

    }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}