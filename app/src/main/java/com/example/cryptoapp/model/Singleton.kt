package com.example.cryptoapp.model

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.cryptoapp.Utils.BASE_URL
import com.example.cryptoapp.Utils.SHARED_PREFERENCES_NAME
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Singleton {
    companion object {
        @Volatile
        private lateinit var retrofit: Retrofit
        private lateinit var room: CoinDataBase

        fun getInstanceRetrofit(): Retrofit {
            synchronized(this){
                if (!::retrofit.isInitialized){
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }
        }

        fun getInstanceRoom(context: Context): CoinDataBase {
            synchronized(this){
                if (!::room.isInitialized){
                    room = Room.databaseBuilder(context, CoinDataBase::class.java, "CoinDB")
                        .build()
                }
                return room
            }
        }
    }
}