package com.example.simpkb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.simpkb.Api.APIRequestData;
import com.example.simpkb.Api.RetroServer;
import com.example.simpkb.Models.ResponseModel;
import com.example.simpkb.model.RegisterApi;
import com.example.simpkb.model.Value;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

public class registrasi extends AppCompatActivity {


    private String nik,nama,provinsi,kabupaten,kecamatan,desa,rt,rw,nohp,password;
    private EditText edregnik, edregnama, edregrt,edregrw,edregno, edregpass;
    private Spinner spprov,spkab,spkec,spdesa;
    private Button btsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
//
        edregnik = findViewById(R.id.edregnik);
        edregnama = findViewById(R.id.edregnama);
        edregrw = findViewById(R.id.edregrw);
        edregno = findViewById(R.id.edregno);
        edregrt = findViewById(R.id.edregrt);
        edregpass = findViewById(R.id.edregpass);

        spprov = findViewById(R.id.spregprov);
        spkab = findViewById(R.id.spregkab);
        spkec = findViewById(R.id.spregkec);
        spdesa = findViewById(R.id.spregdes);

        btsave = findViewById(R.id.btregsimpan);

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edregnik.getText().toString();
                nik = edregnik.getText().toString();
                provinsi = spprov.getSelectedItem().toString();
                kabupaten = spkab.getSelectedItem().toString();
                kecamatan = spkec.getSelectedItem().toString();
                desa = spdesa.getSelectedItem().toString();
                rt = edregrt.getText().toString();
                rw = edregrw.getText().toString();
                nohp = edregno.getText().toString();
                password = edregpass.getText().toString();

                if (nik.trim().equals("")){
                    edregnik.setError("NIK Tidak Boleh Kosong");
                } else if (nama.trim().equals("")){
                    edregnama.setError("Nama Tidak Boleh Kosong");
                } else if (rt.trim().equals("")){
                    edregrt.setError("RT Tidak Boleh Kosong");
                } else if (rw.trim().equals("")){
                    edregrw.setError("RW Tidak Boleh Kosong");
                } else if (nohp.trim().equals("")){
                    edregno.setError("nohp Tidak Boleh Kosong");
                }  else if (password.trim().equals("")){
                    edregno.setError("nohp Tidak Boleh Kosong");
                } else {
                    createData();
                }

            }
        });

    }

    private void createData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> simpanData = ardData.ardCreateData(nik,nama,provinsi,kabupaten,kecamatan,desa,rt,rw,nohp,password);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(registrasi.this, "Kode : "+kode+ "Pesan"+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(registrasi.this, "Gagal Menyimpan"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}

