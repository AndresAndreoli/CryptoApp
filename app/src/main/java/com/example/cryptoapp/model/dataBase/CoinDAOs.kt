package com.example.cryptoapp.model.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.model.coinEntities.CoinEntity

@Dao
interface CoinDAOs {
    @Query("SELECT * FROM latest_coin_table")
    fun getLatestCoin(): List<CoinEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinToDB(coin: CoinEntity)
}