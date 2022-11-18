package com.example.cryptoapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Utilities {
    companion object{
        fun checkConnectionInternet(context: Context): Boolean{
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }
    }
}