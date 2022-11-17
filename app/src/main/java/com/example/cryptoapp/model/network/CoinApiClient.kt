package com.example.cryptoapp.model.network

import com.example.cryptoapp.model.network.Singleton.Companion.getInstanceRetrofit

class CoinApiClient {
    fun getCoinApiClient(): CoinApiService = getInstanceRetrofit().create(CoinApiService::class.java)
}