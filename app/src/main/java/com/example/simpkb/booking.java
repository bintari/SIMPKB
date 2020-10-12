package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
    }

    public void tanpa(View view) {
        Intent tanpa = new Intent(booking.this, tanpanomor.class);
        startActivity(tanpa);
    }

    public void nomor(View view) {
        Intent nomor = new Intent(booking.this, dengannomor.class);
        startActivity(nomor);
    }
}