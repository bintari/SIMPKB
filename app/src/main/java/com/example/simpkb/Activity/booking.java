package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simpkb.LOGIN.Util.SharedPrev;
import com.example.simpkb.R;

public class booking extends AppCompatActivity {
    private TextView usernamebok;
    ImageView button_logoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        usernamebok = findViewById(R.id.usernamebok);
        button_logoutMain = findViewById(R.id.button_logoutbooking);

        findViewById(R.id.button_logoutbooking).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                SharedPrev.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),Login.class));
                finish();
            }
        });

        SharedPrev.setLoggedInStatus(getBaseContext(),1);

        String nama = SharedPrev.getNama(getBaseContext());
        usernamebok.setText(nama);

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