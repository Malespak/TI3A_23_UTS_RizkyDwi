package com.example.rizky.uts_android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManagement {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private Context mContext;

    int PRIVATE_MODE;

    private static final String PREF_NAME = "SharedPrefLatihan";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "email";

    public SessionManagement(Context mContext){
        this.mContext = mContext;
        mSharedPreferences = this.mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = mSharedPreferences.edit();
    }

    public void createLoginSession(String email,String Password){
        mEditor.putBoolean(IS_LOGIN, true);
        mEditor.putString(KEY_EMAIL, Password);
        mEditor.putString(KEY_PASSWORD, email);
        mEditor.commit();
    }

    public HashMap<String, String> getUserInformation(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_EMAIL, mSharedPreferences.getString(KEY_EMAIL, null));
        user.put(KEY_PASSWORD,mSharedPreferences.getString(KEY_PASSWORD,null));
        return user;
    }

    public boolean isLoggedIn(){
        return mSharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void checkIsLogin(){
        if (!isLoggedIn()){
            Intent i = new Intent(mContext, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }

    public void LogoutUser(){
        mEditor.clear();
        mEditor.commit();

        Intent i = new Intent(mContext, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }

}
