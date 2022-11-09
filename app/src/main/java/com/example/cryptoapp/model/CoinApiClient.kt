package com.example.cryptoapp.model

class CoinApiClient: Singleton() {
    fun getCoinApiClient(): CoinApiService = retrofit.create(CoinApiService::class.java)
}