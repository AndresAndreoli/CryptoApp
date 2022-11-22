package com.example.cryptoapp.app.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.app.framework.db.coinEntities.CoinEntity

@Dao
interface CoinDAOs {
    @Query("SELECT * FROM latest_coin_table")
    fun getLatestCoin(): List<CoinEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinToDB(coin: CoinEntity)
}