package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.simpkb.LOGIN.Util.SharedPrev;
import com.example.simpkb.R;

public class dashboard extends AppCompatActivity {
    private TextView usernama;
    Button btdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        usernama = findViewById(R.id.dasusername);

        String cetaknama = SharedPrev.getNama(getBaseContext());
        usernama.setText(cetaknama);

        btdetail = findViewById(R.id.dasdetail);

        btdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this, detail.class);
                startActivity(i);
            }
        });
//
//        Intent intent = getIntent();
//
//
//        if (intent.getExtras()!=null){
//            String passedusername = intent.getStringExtra("data");
//            usernama.setText(passedusername);
//        }
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