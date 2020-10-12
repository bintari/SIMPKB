package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dengannomor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengannomor);
    }

    public void detail(View view) {
        Intent detail = new Intent(dengannomor.this, com.example.simpkb.detail.class);
        startActivity(detail);
    }

    public void dashboard(View view) {
        Intent balik = new Intent(dengannomor.this, dashboard.class);
        startActivity(balik);
    }
}