package com.example.cryptoapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptoapp.model.coinEntities.CoinEntity

@Database(
    entities = [CoinEntity::class],
    version = 1
)
abstract class CoinDataBase: RoomDatabase() {
    // Definir los DAOs
    abstract fun getCoinDao(): CoinDAOs
}