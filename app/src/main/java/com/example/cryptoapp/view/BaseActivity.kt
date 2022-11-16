package com.example.cryptoapp.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptoapp.Utils.SHARED_PREFERENCES_NAME

open class BaseActivity: AppCompatActivity() {
    protected val preferences: SharedPreferences by lazy{
        getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}