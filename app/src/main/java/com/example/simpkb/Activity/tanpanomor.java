package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.simpkb.Nomorantrian.Api.RetroServer;
import com.example.simpkb.R;
import com.example.simpkb.booking1.ApiBooking.ApiRequestBooking;
import com.example.simpkb.booking1.ApiBooking.RetroServerAntrian;
import com.example.simpkb.booking1.ModelBooking.ResponseModelBooking;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class tanpanomor extends AppCompatActivity {
    public static final String URL = "http://192.168.43.85/magang/booking/";
    Button simpan;
    EditText tanggal, nomor;
    Spinner jenis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanpanomor);

        simpan = findViewById(R.id.btnsimpantn);
        tanggal = findViewById(R.id.tanggalbooking);
        nomor = findViewById(R.id.nomorkendaraan);
        jenis = findViewById(R.id.spjenispelayanan);
        simpan = findViewById(R.id.btnsimpantn);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiRequestBooking apibooking = RetroServerAntrian.getretro().create(ApiRequestBooking.class);
                String tanggalbooking = tanggal.getText().toString();
                String nomorkendaraan = nomor.getText().toString();
                String spjenispelayanan = jenis.getSelectedItem().toString();

//                Call<ResponseModelBooking> bokingbaru = apibooking.getbookingtanpa(tanggalbooking,nomorkendaraan,spjenispelayanan);
            }
        });
    }
}
