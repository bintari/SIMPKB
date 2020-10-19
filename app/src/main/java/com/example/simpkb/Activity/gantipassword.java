package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simpkb.R;

public class gantipassword extends AppCompatActivity {
    Button ganti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gantipassword);

        ganti = findViewById(R.id.ganti);

        ganti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(gantipassword.this, Login.class);
                startActivity(c);
            }
        });
    }
}