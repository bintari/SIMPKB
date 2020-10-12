package com.example.simpkb.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpkb.Api.APIRequestData;
import com.example.simpkb.Api.RetroServer;
import com.example.simpkb.Lihat;
import com.example.simpkb.Models.DataModel;
import com.example.simpkb.Models.ResponseModel;
import com.example.simpkb.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterDAta extends  RecyclerView.Adapter<AdapterDAta.HolderData>{
    private Context ctx ;
    private List<DataModel> listnama;
    private int idNama;

    public AdapterDAta(Context ctx, List<DataModel> listnama) {
        this.ctx = ctx;
        this.listnama = listnama;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listnama.get(position);

        holder.tvId.setText(String.valueOf(dm.getNik()));
        holder.tvNama.setText(dm.getNama());
        holder.tvAlamat.setText(dm.getProvisi());
        holder.tvTelepon.setText(dm.getKabupaten());

    }

    @Override
    public int getItemCount() {
        return listnama.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId, tvNama, tvAlamat, tvTelepon;

        public HolderData(@NonNull View itemView) {
            super(itemView);


            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvTelepon = itemView.findViewById(R.id.tv_telepon);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Pilih Operasi ");
                    dialogPesan.setIcon(R.mipmap.ic_launcher);
                    dialogPesan.setCancelable(true);

                    idNama = Integer.parseInt(tvId.getText().toString());

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteData();
                            dialog.dismiss();
                        ((Lihat)ctx).retriveData();
                        }
                    });
                    dialogPesan.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {




                        }
                    });
                    dialogPesan.show();

                    return false;
                }
            });

        }

        private void deleteData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData = ardData.ardDeleteData(idNama);

            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                    Toast.makeText(ctx, "Kode"+kode+"Pesan"+pesan, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungi Server"+t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}
