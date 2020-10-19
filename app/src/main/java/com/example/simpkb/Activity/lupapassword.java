package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simpkb.R;

public class lupapassword extends AppCompatActivity {
    Button lupa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupapassword);

        lupa = findViewById(R.id.lupa);

        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(lupapassword.this, gantipassword.class);
                startActivity(a);
            }
        });
    }
}