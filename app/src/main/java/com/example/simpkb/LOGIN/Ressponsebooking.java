package com.example.simpkb.LOGIN;


import java.util.List;

public class Ressponsebooking {
    private String tanggalbooking;
    private String nomorkendaraan;
    private String jenispelayanan;
    private String kode;
    private String pesan;


    private UserModelBooking data;

    public Ressponsebooking(String tanggalbooking, String nomorkendaraan, String jenispelayanan) {
        this.tanggalbooking = tanggalbooking;
        this.nomorkendaraan = nomorkendaraan;
        this.jenispelayanan = jenispelayanan;
    }

    public String getTanggalbooking() {
        return tanggalbooking;
    }

    public void setTanggalbooking(String tanggalbooking) {
        this.tanggalbooking = tanggalbooking;
    }

    public String getNomorkendaraan() {
        return nomorkendaraan;
    }

    public void setNomorkendaraan(String nomorkendaraan) {
        this.nomorkendaraan = nomorkendaraan;
    }

    public String getJenispelayanan() {
        return jenispelayanan;
    }

    public void setJenispelayanan(String jenispelayanan) {
        this.jenispelayanan = jenispelayanan;
    }


    public UserModelBooking getData() {
        return data;
    }

    public void setData(UserModelBooking data) {
        this.data = data;
    }

    public String getKode() {
        return kode;
    }

    public String getPesan() {
        return pesan;
    }


}
