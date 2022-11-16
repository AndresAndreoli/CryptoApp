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

    // OnConflictStrategy.REPLACE = If there's already another element with the same primary key, the new element will replace the old one
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinToDB(coin: CoinEntity)
}