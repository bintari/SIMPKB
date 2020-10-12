package com.example.simpkb.Models;

import java.util.List;

public class ResponseModel {

    private int kode;
    private String pesan;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<DataModel> getData(){ return data;}
    public void SetData(List<DataModel> data){
        this.data= data;
    }

    private List<DataModel> data;
}
