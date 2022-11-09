package com.example.cryptoapp.view.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptoapp.R
import com.example.cryptoapp.model.CoinApiClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var hola = CoinApiClient().getCoinApiClient().getCoinByID(1)
    }
}