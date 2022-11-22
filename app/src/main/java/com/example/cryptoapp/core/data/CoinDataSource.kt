package com.example.cryptoapp.core.data

import com.example.cryptoapp.model.CoinDetails
import com.example.cryptoapp.model.CoinModel

interface CoinDataSource {
    suspend fun getLatestCoinsDB(): List<CoinModel>

    suspend fun getLatestCoinsNetwork(): List<CoinModel>?

    suspend fun getCoinByID(id: Int): CoinDetails?
}