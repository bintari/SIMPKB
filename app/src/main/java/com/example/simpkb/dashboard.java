package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {
    private TextView usernama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        usernama = findViewById(R.id.dasusername);

        Intent intent = getIntent();


        if (intent.getExtras()!=null){
            String passedusername = intent.getStringExtra("data");
            usernama.setText(passedusername);
        }
    }

    public void booking(View view) {
        Intent boking = new Intent(dashboard.this, booking.class);
        startActivity(boking);
    }

    public void bukti(View view) {
//        Intent bukti = new Intent( dashboard.this, .class);

    }

    public void antrian(View view) {
    }

    public void kontak(View view) {
    }
}