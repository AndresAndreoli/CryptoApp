package com.example.cryptoapp.view.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.R
import com.example.cryptoapp.model.CoinApiClient
import com.example.cryptoapp.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Testing coin request (this will be remove in the future)
        //viewModel.getCoinById(2)
    }
}