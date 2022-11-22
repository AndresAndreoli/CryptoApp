package com.example.cryptoapp.app.framework.network

import com.example.cryptoapp.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class CoinApiClient {
    companion object {
        @Volatile
        private lateinit var retrofit: Retrofit

        private fun getInstanceRetrofit(): Retrofit {
            synchronized(this){
                if (!Companion::retrofit.isInitialized){
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }
        }

        fun getCoinApiClient(): CoinApiService = getInstanceRetrofit().create(CoinApiService::class.java)
    }
}