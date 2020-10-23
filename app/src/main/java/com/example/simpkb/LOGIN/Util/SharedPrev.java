package com.example.simpkb.LOGIN.Util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.preference.PreferenceManager;

import com.example.simpkb.Activity.Login;

import java.util.HashMap;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class SharedPrev {
    public static final String SP_ID = "id";
    public static final String SP_USERNAME = "username";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";
    private SharedPreferences sp;
    public static final String KEY_USERNAME = "username";
    public static final String KEY_NIK = "nik";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NOTELP ="notelp";
    public static final String KEY_ALAMAT = "alamat";
    public static String  KEY_STATUS = "status";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_KODELINK = "kodelink";
    public static final String KEY_ROLE ="role";
    public static final String KEY_RT = "rt";
    public static final String KEY_RW = "rw";
    public static final String KEY_KELURAHAN ="kelurahan";
    public static final String KEY_KABUPATEN ="kabupaten";
    public static final String KEY_PROVINSI ="provinsi";
    public static final String KEY_KECAMATAN ="kecamatan";
    public static final String KEY_TGLDAFTAR = "tgldaftar";
    public static final String KEY_COUNT ="count_sms_verif_ul";
    public static final String KEY_STATUS_SMS="status_sms";
    public static final String KEY_TIME_SEND = "time_send";
    private static final String KEY_USERNAME_SEDANG_LOGIN = "Status_logged_in";
    private static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";






    public static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setRegisteredUser(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NIK, username);
        editor.apply();
    }

    public static String getRegisteredUser(Context context){
        return getSharedPreference(context).getString(KEY_NIK,"");
    }

    public static void setRegisteredPass(Context context, String password){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    /** Mengembalikan nilai dari key KEY_PASS_TEREGISTER berupa String */
    public static String getRegisteredPass(Context context){
        return getSharedPreference(context).getString(KEY_PASSWORD,"");
    }

    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key KEY_USERNAME_SEDANG_LOGIN dengan parameter username */
    public static void setLoggedInUser(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NIK, username);
        editor.apply();
    }

    /** Mengembalikan nilai dari key KEY_USERNAME_SEDANG_LOGIN berupa String */
    public static String getLoggedInUser(Context context){
        return getSharedPreference(context).getString(KEY_NIK,"");
    }

    public static Integer getLoggedInStatus(Context context){
        return getSharedPreference(context).getInt(KEY_STATUS,1);
    }


    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key KEY_STATUS_SEDANG_LOGIN dengan parameter status */
    public static void setLoggedInStatus(Context context, Integer status){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putInt(KEY_STATUS, status);
        editor.apply();
    }

    public static void setUsernameLog(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public static String  getUsernameLog(Context context){
        return getSharedPreference(context).getString(KEY_USERNAME,"");
    }

    public static void setNama(Context context, String nama){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NAMA, nama);
        editor.apply();
    }

    public static String getNama(Context context){
        return getSharedPreference(context).getString(KEY_NAMA,"");
    }

    public static void setNoTelepon(Context context, String telepon){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NOTELP, telepon);
        editor.apply();
    }

    public static String getalamat(Context context){
        return getSharedPreference(context).getString(KEY_ALAMAT,"");
    }

    public static void setalamat(Context context, String telepon){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_ALAMAT, telepon);
        editor.apply();
    }

    public static String getNoTelepon(Context context){
        return getSharedPreference(context).getString(KEY_NOTELP,"");
    }


    /** Deklarasi Edit Preferences dan menghapus data, sehingga menjadikannya bernilai default
     *  khusus data yang memiliki key KEY_USERNAME_SEDANG_LOGIN dan KEY_STATUS_SEDANG_LOGIN */
    public static void clearLoggedInUser (Context context) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.remove(KEY_USERNAME_SEDANG_LOGIN);
        editor.remove(KEY_STATUS_SEDANG_LOGIN);
        editor.apply();
    }



}
