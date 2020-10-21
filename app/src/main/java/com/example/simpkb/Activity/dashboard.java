package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simpkb.LOGIN.Util.SharedPrev;
import com.example.simpkb.R;

import java.util.prefs.Preferences;

public class dashboard extends AppCompatActivity {
    private TextView usernama;
    Button btdetail;
    ImageView button_logoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        usernama = findViewById(R.id.dasusername);
        button_logoutMain = findViewById(R.id.button_logoutMain);

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

        findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                SharedPrev.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),Login.class));
                finish();
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
//        Intent boking = new Intent(dashboard.this, tanpanomor.class);
//        startActivity(boking);
        startActivity(new Intent(getBaseContext(),tanpanomor.class));
    }

    public void bukti(View view) {
//        Intent bukti = new Intent( dashboard.this, .class);

    }

    public void antrian(View view) {
    }

    public void kontak(View view) {
    }
}