package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class registrasi extends AppCompatActivity {

    EditText regnik,regnama,regrt,regrw,regno;
    Spinner regprov,regkab,regkec,regdes;
    Button regsimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        regnik = findViewById(R.id.edregnik);
        regnama = findViewById(R.id.edregnama);
        regrt = findViewById(R.id.edregrt);
        regrw = findViewById(R.id.edregrw);
        regno = findViewById(R.id.edregno);

        regprov = findViewById(R.id.spregprov);
        regkab = findViewById(R.id.spregkab);
        regkec = findViewById(R.id.spregkec);
        regdes = findViewById(R.id.spregdes);

        regsimpan = findViewById(R.id.btregsimpan);

    }
}