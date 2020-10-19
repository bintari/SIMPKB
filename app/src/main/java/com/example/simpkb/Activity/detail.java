package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.simpkb.LOGIN.Util.SharedPrev;
import com.example.simpkb.R;

public class detail extends AppCompatActivity {

    TextView namauserdet;
    TextView nikdet;
    TextView nikdetailprof;
    TextView namadetailprof,alamatdetailprof,nohpdetailprof;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        namauserdet = findViewById(R.id.namauser);
        nikdet = findViewById(R.id.nikdetail);
        nikdetailprof = findViewById(R.id.nikdetailprof);
        namadetailprof = findViewById(R.id.namadetailprof);
        alamatdetailprof = findViewById(R.id.alamatdetailprof);
        nohpdetailprof = findViewById(R.id.nohpdetailprof);

        String nama = SharedPrev.getNama(getBaseContext());
        String nik = SharedPrev.getUsernameLog(getBaseContext());
        String alamat = SharedPrev.getalamat(getBaseContext());
        String nomor = SharedPrev.getNoTelepon(getBaseContext());


        namauserdet.setText(nama);
        nikdet.setText(nik);
        nikdetailprof.setText(nik);
        namadetailprof.setText(nama);
        alamatdetailprof.setText(alamat);
        nohpdetailprof.setText(nomor);

    }
}