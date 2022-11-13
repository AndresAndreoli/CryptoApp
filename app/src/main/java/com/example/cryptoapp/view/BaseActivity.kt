package com.example.cryptoapp.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {
    protected val preferences: SharedPreferences by lazy{
        getSharedPreferences("UserCredentials", Context.MODE_PRIVATE)
    }
}