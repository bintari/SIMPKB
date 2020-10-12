package com.example.simpkb.Models;

import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("nik")
    String nik;
    @SerializedName("password")
    String password;

    public LoginModel(String nik, String password) {
        this.nik = nik;
        this.password = password;
    }
}
