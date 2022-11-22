package com.example.cryptoapp.app.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptoapp.app.framework.db.coinEntities.CoinEntity
import com.example.cryptoapp.utils.DATA_BASE_NAME

@Database(
    entities = [CoinEntity::class],
    version = 1
)
abstract class CoinDataBase: RoomDatabase() {
    abstract fun getCoinDao(): CoinDAOs

    companion object {
        @Volatile
        private lateinit var room: CoinDataBase

        fun getInstanceRoom(context: Context): CoinDataBase =
            synchronized(this){
                if (!Companion::room.isInitialized){
                    room = Room.databaseBuilder(context, CoinDataBase::class.java, DATA_BASE_NAME)
                        .build()
                }
                return room
            }
    }
}