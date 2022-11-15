package com.example.cryptoapp.model

import androidx.room.Dao
import androidx.room.Query
import com.example.cryptoapp.model.coinEntities.CoinEntity

@Dao
interface CoinDAOs {

    @Query("SELECT * FROM latest_coin_table")
    fun getLatestCoin(): List<CoinEntity>
}