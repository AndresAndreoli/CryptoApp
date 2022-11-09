package com.example.cryptoapp.model

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


const val API_KEY = "dd36ae30-4298-4e69-8a04-e1abb148a5c8"

interface CoinApiService {
    @Headers("X-CMC_PRO_API_KEY", API_KEY)
    @GET("/v2/cryptocurrency/info")
    fun getCoinByID(@Query ("id") id: Int): Observable<Response<CoinModel>>
}