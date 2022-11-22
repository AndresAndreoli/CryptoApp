package com.example.cryptoapp.app.presentation.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.cryptoapp.utils.DATA_BASE_NAME
import com.example.cryptoapp.utils.SHARED_PREFERENCES_NAME
import com.example.cryptoapp.app.framework.db.CoinDataBase
import com.example.cryptoapp.app.framework.network.CoinApiClient
import com.example.cryptoapp.app.framework.network.CoinApiService

open class BaseActivity: AppCompatActivity() {
    protected val preferences: SharedPreferences by lazy{
        getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Volatile
    private lateinit var apiService: CoinApiService
    @Volatile
    private lateinit var room: CoinDataBase

    protected fun getAPIService(): CoinApiService {
        synchronized(this){
            if (!::apiService.isInitialized){
                apiService = CoinApiClient().getCoinApiClient()
            }
            return apiService
        }
    }

    protected fun getInstanceRoom(): CoinDataBase {
        synchronized(this){
            if (!::room.isInitialized){
                room = Room.databaseBuilder(this, CoinDataBase::class.java, DATA_BASE_NAME)
                    .build()
            }
            return room
        }
    }
}
