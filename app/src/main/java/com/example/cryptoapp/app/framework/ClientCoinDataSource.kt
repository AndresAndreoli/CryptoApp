package com.example.cryptoapp.app.framework

import android.content.Context
import com.example.cryptoapp.app.framework.db.CoinDataBase
import com.example.cryptoapp.app.framework.network.CoinApiClient
import com.example.cryptoapp.core.data.CoinDataSource
import com.example.cryptoapp.model.CoinDetails
import com.example.cryptoapp.model.CoinModel
import com.example.cryptoapp.utils.toModel

class ClientCoinDataSource(context: Context): CoinDataSource {

    private val roomClient = CoinDataBase.getInstanceRoom(context).getCoinDao()
    private val apiClient = CoinApiClient.getCoinApiClient()

    override suspend fun getLatestCoinsDB(): List<CoinModel> =
        roomClient.getLatestCoin()
        .map { it.toModel() }

    override suspend fun getLatestCoinsNetwork(): List<CoinModel>? =
        apiClient.getLatestCoins()
        .body()?.data


    override suspend fun getCoinByID(id: Int): CoinDetails? =
        apiClient.getCoinById(id).body()?.data?.get(id)
}