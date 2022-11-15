package com.example.cryptoapp.model

import android.util.Log
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class CoinRepository {
    val coinApiClient = CoinApiClient()

    fun getLatestCoins(){
        val observable = coinApiClient.getCoinApiClient().getLatestCoins()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

        observable.subscribe(getObserverLatestCoin())
    }

    fun getCoinById(id: Int){
        val observable = coinApiClient.getCoinApiClient().getCoinById(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

        observable.subscribe(getObserverCoinDetails())
    }

    private fun getObserverLatestCoin(): Observer<Response<BaseResponse<List<LatestCoin>>>> {
        return object : Observer<Response<BaseResponse<List<LatestCoin>>>> {
            override fun onNext(response: Response<BaseResponse<List<LatestCoin>>>) {
                // TODO: ALMACENAR EN BASE DE DATOS
                Log.d("mainViewModel", "Response: ${response.body()}")
            }

            override fun onError(e: Throwable) {
                Log.d("mainViewModel", e.message ?: "Error request (Latest coins)")
            }

            override fun onComplete() {
                Log.d("mainViewModel",  "Complete request (Latest coins)")
            }

            override fun onSubscribe(d: Disposable) { }
        }
    }

    private fun getObserverCoinDetails(): Observer<Response<BaseResponse<Map<Int, CoinDetails?>>>> {
        return object : Observer<Response<BaseResponse<Map<Int, CoinDetails?>>>> {
            override fun onSubscribe(d: Disposable) { }

            override fun onError(e: Throwable) {
                Log.d("mainViewModel", e.message ?: "Error request (Coin details)")
            }

            override fun onComplete() {
                Log.d("mainViewModel",  "Complete request (Coin details)")
            }

            override fun onNext(response: Response<BaseResponse<Map<Int, CoinDetails?>>>) {
                Log.d("mainViewModel", "Response: ${response.body()}")
            }
        }
    }
}