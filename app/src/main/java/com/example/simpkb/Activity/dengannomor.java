package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.simpkb.R;
import com.example.simpkb.booking1.ApiBooking.ApiRequestBooking;
import com.example.simpkb.booking1.ApiBooking.RetroServerAntrian;
import com.example.simpkb.booking1.ModelBooking.ResponseModelBooking;
import com.example.simpkb.booking2.Apibookingnomor.ApiReqbookingnomor;
import com.example.simpkb.booking2.Apibookingnomor.RetroServerbokingnomor;
import com.example.simpkb.booking2.modelbookingnomor.ResponseModelBookingnomor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dengannomor extends AppCompatActivity {
    public static final String URL = "http://192.168.43.85/magang/booking/";

//    String noujian,platnomor;
//    Button simpan;
    EditText noujian1, platnomor1;
    private Object ApiReqbookingnomor;
//    Spinner jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengannomor);

        noujian1 = findViewById(R.id.noujin);
        platnomor1 = findViewById(R.id.platnomor);
    }

    public void detail(View view) {
        Intent detail = new Intent(dengannomor.this, com.example.simpkb.Activity.detail.class);
        startActivity(detail);
    }

    public void dashboard(View view) {
        Intent balik = new Intent(dengannomor.this, dashboard.class);
        startActivity(balik);
    }

    public void simpannomor(View view) {
        String noujian = noujian1.getText().toString();
        String platnomor = platnomor1.getText().toString();
        com.example.simpkb.booking2.Apibookingnomor.ApiReqbookingnomor api = RetroServerbokingnomor.getbooking().create(com.example.simpkb.booking2.Apibookingnomor.ApiReqbookingnomor.class);
        Call<ResponseModelBookingnomor> booking = api.getbookingnomor(noujian,platnomor);
        booking.enqueue(new Callback<ResponseModelBookingnomor>() {
            @Override
            public void onResponse(Call<ResponseModelBookingnomor> call, Response<ResponseModelBookingnomor> response) {
//                Toast.makeText(dengannomor.this, "jadi", Toast.LENGTH_SHORT).show();
                Log.d("RETRO", "response : "+response.body().toString());
                Integer kode = response.body().getKode();

                if(kode.equals(1)){
                    Toast.makeText(dengannomor.this, "simpan data", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(dengannomor.this, "gagal simpan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModelBookingnomor> call, Throwable t) {
                Toast.makeText(dengannomor.this, "gagal nyambung", Toast.LENGTH_SHORT).show();
                System.out.println("bintari :  "+t.getLocalizedMessage());
            }
        });
    }
}