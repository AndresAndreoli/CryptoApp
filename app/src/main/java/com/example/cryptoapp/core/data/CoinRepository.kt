package com.example.cryptoapp.core.data

class CoinRepository (private val dataSource: CoinDataSource) {
    suspend fun getLatestCoinsDB() = dataSource.getLatestCoinsDB()

    suspend fun getLatestCoinsNetwork() = dataSource.getLatestCoinsNetwork()

    suspend fun getCoinByID(id: Int) = dataSource.getCoinByID(id)
}