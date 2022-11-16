package com.example.cryptoapp.model

import com.example.cryptoapp.Utils.API_KEY
import com.example.cryptoapp.Utils.END_POINT_DETAILS_COIN
import com.example.cryptoapp.Utils.END_POINT_LATEST_COINS
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CoinApiService {
    @Headers("X-CMC_PRO_API_KEY: ${API_KEY}", "Accept: application/json")
    @GET(END_POINT_LATEST_COINS)
    fun getLatestCoins(): Observable<Response<BaseResponse<List<LatestCoin>>>>

    @Headers("X-CMC_PRO_API_KEY: ${API_KEY}", "Accept: application/json")
    @GET(END_POINT_DETAILS_COIN)
    fun getCoinById(@Query("id") id: Int): Observable<Response<BaseResponse<Map<Int,CoinDetails?>>>>
}