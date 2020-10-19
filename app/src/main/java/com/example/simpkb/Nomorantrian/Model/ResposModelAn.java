package com.example.simpkb.Nomorantrian.Model;

import android.content.Intent;

import com.example.simpkb.Nomorantrian.Api.ApiRequestAntrian;
import com.google.gson.annotations.SerializedName;

public class ResposModelAn {
    Integer status;
    String message;
    String data;
    Integer total;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
