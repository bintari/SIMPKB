package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tanpanomor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanpanomor);
    }

    public void detailprof(View view) {
        Intent detailp = new Intent(tanpanomor.this, detail.class);
        startActivity(detailp);
    }

    public void simpandet(View view) {
        Intent simpandata = new Intent(tanpanomor.this, dashboard.class);
        startActivity(simpandata);
    }
}