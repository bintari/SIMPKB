package com.example.simpkb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.simpkb.Api.ApiRequestReg;
import com.example.simpkb.Api.Retroserver;
import com.example.simpkb.Models.ResponseModelReg;
import com.example.simpkb.R;
import com.example.simpkb.Spinner.SpinnerInterface;
import com.example.simpkb.Spinner.SpinnerModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Field;

import static android.R.layout.simple_spinner_item;

public class registrasi extends AppCompatActivity {

    private String nik, nama, provinsi, kabupaten, kecamatan, kelurahan, rt, rw, notelp, password, email, alamat, kode_verifikasi, status, token, kodelink, role, id, count_sms_verif_ul, status_sms, time_send, tgldaftar;
    private EditText edregnik, edregnama, edregemail, edregalamat, edregrt, edregrw, edregno, edregpass;
    private Spinner spprov, spkab, spkec, spdesa;
    private Button btsave;

    //Spinner
    private ArrayList<SpinnerModel> arrayModel;
    private ArrayList<String> Provinsiname = new ArrayList<String>();
    private Spinner Spinnerprov;
    //end spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
//
        edregnik = findViewById(R.id.edregnik);
        edregnama = findViewById(R.id.edregnama);
        edregemail = findViewById(R.id.edregemail);
        edregalamat = findViewById(R.id.edregalamat);
        edregrw = findViewById(R.id.edregrw);
        edregno = findViewById(R.id.edregno);
        edregrt = findViewById(R.id.edregrt);
        edregpass = findViewById(R.id.edregpass);
        spkab = findViewById(R.id.spregkab);
        spkec = findViewById(R.id.spregkec);
        spdesa = findViewById(R.id.spregdes);
        btsave = findViewById(R.id.btregsimpan);

        //spinner
        Spinnerprov = findViewById(R.id.spProv);
        fetchJSON();
        //endspinner
        
        
        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edregnik.getText().toString();
                nik = edregnik.getText().toString();
                alamat = edregalamat.getText().toString();
                email = edregemail.getText().toString();
                provinsi = spprov.getSelectedItem().toString();
                kabupaten = spkab.getSelectedItem().toString();
                kecamatan = spkec.getSelectedItem().toString();
                kelurahan = spdesa.getSelectedItem().toString();
                rt = edregrt.getText().toString();
                rw = edregrw.getText().toString();
                notelp = edregno.getText().toString();
                password = edregpass.getText().toString();

                if (nik.trim().equals("")) {
                    edregnik.setError("NIK Tidak Boleh Kosong");
                } else if (nama.trim().equals("")) {
                    edregnama.setError("Nama Tidak Boleh Kosong");
                } else if (rt.trim().equals("")) {
                    edregrt.setError("RT Tidak Boleh Kosong");
                } else if (rw.trim().equals("")) {
                    edregrw.setError("RW Tidak Boleh Kosong");
                } else if (notelp.trim().equals("")) {
                    edregno.setError("nohp Tidak Boleh Kosong");
                } else if (password.trim().equals("")) {
                    edregno.setError("nohp Tidak Boleh Kosong");
                } else {
                    createData();
                }

            }
        });
        
    }
//spinner
private void fetchJSON() {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SpinnerInterface.JSONURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    SpinnerInterface api = retrofit.create(SpinnerInterface.class);

    Call<JsonObject> call = api.getData();


    call.enqueue(new Callback<JsonObject>() {
        @Override
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Log.i("Responsestring", response.body().toString());

            //Toast.makeText()
            if (response.isSuccessful()) {
                if (response.body() != null) {

                    arrayModel = new ArrayList<SpinnerModel>();
                    JsonArray dataProv = response.body().getAsJsonArray("data");
                    for (int i = 0;i < dataProv.size();i++){
                        Log.i("onSuccess", dataProv.get(i).getAsJsonObject().get("id").getAsString());
                        SpinnerModel data = new SpinnerModel(dataProv.get(i).getAsJsonObject().get("id").getAsString(),dataProv.get(i).getAsJsonObject().get("prov").getAsString());
                        arrayModel.add(data);
                        Provinsiname.add(data.getProv());
                    }
                    String jsonresponse = response.body().toString();
                    spinJSON(jsonresponse);
                    System.out.println("bintari respon body = "+jsonresponse);

                    ArrayAdapter<String> spinnerprovinsiadapter = new ArrayAdapter<String>(registrasi.this, simple_spinner_item, Provinsiname);
                    spinnerprovinsiadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    Spinnerprov.setAdapter(spinnerprovinsiadapter);

                } else {
                    Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                }
            }
        }

        @Override
        public void onFailure(Call<JsonObject> call, Throwable t) {

        }
    });
}


    private void spinJSON(String response){

        try {


            JSONObject obj = new JSONObject(response);
            if(obj.optString("status").equals(1)){
                arrayModel = new ArrayList<>();

                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {
//                    SpinnerModel spinnerModel = new SpinnerModel();
                    JSONObject dataobj = dataArray.getJSONObject(i);
//
//                    spinnerModel.setProv(dataobj.getString("prov"));
//                    spinnerModel.setId(dataobj.getString("id"));
////
//
//                    arrayModel.add(spinnerModel);
                    System.out.println("bintari = "+arrayModel);

                }

                for (int i = 0; i < arrayModel.size(); i++){
                    Provinsiname.add(arrayModel.get(i).getProv().toString());
                }

                ArrayAdapter<String> spinnerprovinsiadapter = new ArrayAdapter<String>(registrasi.this, simple_spinner_item, Provinsiname);
                spinnerprovinsiadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                Spinnerprov.setAdapter(spinnerprovinsiadapter);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private void createData() {
        ApiRequestReg ardData = Retroserver.konekRetrofit().create(ApiRequestReg.class);
        Call<ResponseModelReg> simpanData = ardData.sendReg(nik, nama, email, notelp, alamat, password, kode_verifikasi, status, token, kodelink, role, rt, rw, kelurahan, id, count_sms_verif_ul, status_sms, time_send, tgldaftar);

        simpanData.enqueue(new Callback<ResponseModelReg>() {
            @Override
            public void onResponse(Call<ResponseModelReg> call, Response<ResponseModelReg> response) {
                String status = response.body().getStatus();
                String message = response.body().getMessage();
////
////                Intent i = new Intent (registrasi.this, MainActivity.class);
//                startActivity(i);
                Toast.makeText(registrasi.this, "Statusnya : " + status + "pesannya : " + message, Toast.LENGTH_SHORT).show();


                System.out.println("jadi tapi : " + response.body());
                System.out.println("pesannya = " + status + "kodenya = " + message);
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModelReg> call, Throwable t) {
                Toast.makeText(registrasi.this, "Gagal Menyimpan" + t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("gagal: " + t.getLocalizedMessage());
            }
        });
    }


}







