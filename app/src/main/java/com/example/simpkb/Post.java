package com.example.simpkb;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int status;
    private String message;
    private String data;
    private String no_antrian;
    private String total;
    @SerializedName("body")
    private String text;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    public String getNo_antrian() {
        return no_antrian;
    }

    public String getTotal() {
        return total;
    }

    public String getText() {
        return text;
    }
}

//public class Post {
//    private int userId;
//    private int id;
//    private String title;
//    //ambil dari body pemanggilan text
//    @SerializedName("body")
//    private String text;
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getText() {
//        return text;
//    }
//}
