package com.example.cryptoapp.model.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptoapp.model.coinEntities.CoinEntity

@Database(
    entities = [CoinEntity::class],
    version = 1
)
abstract class CoinDataBase: RoomDatabase() {
    abstract fun getCoinDao(): CoinDAOs
}