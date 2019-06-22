package com.uas.buahapaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by roningrum on 22/06/2019 2019.
 */
public class Preferences {
    //kunci untuk menyimpan data username dan password
    static final String KEY_USERNAME_LOGIN ="username_log_in";
    static final String KEY_PASSWORD_LOGIN ="password_log_in";
    //deklarasi shared preferences
    private static SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    /**
     *Nilai edit text username akan diambil di method ini
     */
    public static void setLoginUsername (Context context, String username){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_USERNAME_LOGIN, username);
        editor.apply();
    }
    /**
     *Nilai edit text username akan dikembalikan di method ini
     */
    public static String getLoginUser (Context context){
        return getSharedPreferences(context).getString(KEY_USERNAME_LOGIN,"");
    }

    /**
     *Nilai edit text password akan diambil di method ini
     */
    public static void setLoginPassword (Context context, String password){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_PASSWORD_LOGIN, password);
        editor.apply();
    }
    /**
     *Nilai edit text password akan dikembalikan di method ini
     */
    public static String getLoginPassword (Context context){
        return getSharedPreferences(context).getString(KEY_PASSWORD_LOGIN,"");
    }
    //ketika logout dihapus
    public static void clearLoginUser(Context context){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove(KEY_USERNAME_LOGIN);
        editor.remove(KEY_PASSWORD_LOGIN);
        editor.apply();
    }

}
