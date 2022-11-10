package com.example.cryptoapp.model

import com.example.cryptoapp.model.Singleton.Companion.getInstanceRetrofit

class CoinApiClient {
    fun getCoinApiClient(): CoinApiService = getInstanceRetrofit().create(CoinApiService::class.java)
}