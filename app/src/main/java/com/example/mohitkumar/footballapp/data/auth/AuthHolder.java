package com.example.mohitkumar.footballapp.data.auth;

import com.example.mohitkumar.footballapp.BuildConfig;

public class AuthHolder {

    public String getAuthorization() {
        return BuildConfig.AUTH_CODE;
    }
}
