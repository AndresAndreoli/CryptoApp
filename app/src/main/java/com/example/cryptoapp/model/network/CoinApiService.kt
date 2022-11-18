package com.example.cryptoapp.model.network

import com.example.cryptoapp.utils.API_KEY
import com.example.cryptoapp.utils.END_POINT_DETAILS_COIN
import com.example.cryptoapp.utils.END_POINT_LATEST_COINS
import com.example.cryptoapp.model.BaseResponse
import com.example.cryptoapp.model.CoinDetails
import com.example.cryptoapp.model.CoinModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CoinApiService {
    @Headers("X-CMC_PRO_API_KEY: ${API_KEY}", "Accept: application/json")
    @GET(END_POINT_LATEST_COINS)
    suspend fun getLatestCoins(): Response<BaseResponse<List<CoinModel>>>

    @Headers("X-CMC_PRO_API_KEY: ${API_KEY}", "Accept: application/json")
    @GET(END_POINT_DETAILS_COIN)
    suspend fun getCoinById(@Query("id") id: Int): Response<BaseResponse<Map<Int, CoinDetails?>>>
}