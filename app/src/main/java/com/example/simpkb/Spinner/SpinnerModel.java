package com.example.simpkb.Spinner;

public class SpinnerModel {
    private String id,prov;

    public SpinnerModel(String id, String prov) {
        this.id = id;
        this.prov = prov;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }
}
