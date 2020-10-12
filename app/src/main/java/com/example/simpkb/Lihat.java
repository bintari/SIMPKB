package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.simpkb.Adapter.AdapterDAta;
import com.example.simpkb.Api.APIRequestData;
import com.example.simpkb.Api.RetroServer;
import com.example.simpkb.Models.DataModel;
import com.example.simpkb.Models.ResponseModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lihat extends AppCompatActivity {

    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        rvData = findViewById(R.id.rv_data);
        lmData = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);
    }

    public void retriveData() {

        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetriveData();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                //Toast.makeText(MainActivity.this, "Kode"+kode+"Pesan"+pesan, Toast.LENGTH_SHORT).show();

                listData = response.body().getData();

                adData = new AdapterDAta(Lihat.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(Lihat.this,"Gagal :"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });


    }
    protected void onResume(){
        super.onResume();
        retriveData();
    }
}
