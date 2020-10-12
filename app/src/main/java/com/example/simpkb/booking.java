package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class booking extends AppCompatActivity {
    private TextView usernamebok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        usernamebok = findViewById(R.id.usernamebok);

        Intent intent = getIntent();


        if (intent.getExtras()!=null){
            String passedusername = intent.getStringExtra("data");
            usernamebok.setText(passedusername);
        }
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