package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {
    RelativeLayout a,b,c;
    LinearLayout d;
    ImageView login, lupa;

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



        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);



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