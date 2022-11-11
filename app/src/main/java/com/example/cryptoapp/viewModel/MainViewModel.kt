package com.example.cryptoapp.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.model.CoinApiClient
import com.example.cryptoapp.model.CoinDetailsModel
import com.example.cryptoapp.model.CoinModel
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class MainViewModel: ViewModel() {
    fun getLatestCoins(){
        val observable = CoinApiClient().getCoinApiClient().getLastestCoins()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

        observable.subscribe(getObserverCoin())
    }

    private fun getObserverCoin(): Observer<Response<CoinModel>>{
        return object : Observer<Response<CoinModel>>{
            override fun onNext(response: Response<CoinModel>) {
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

    fun getCoinById(id: Int){
        val observable = CoinApiClient().getCoinApiClient().getCoinById(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

        observable.subscribe(getObserverCoinDetails())
    }

    // TODO: HACER FUNCION GENERICA
    fun getObserverCoinDetails(): Observer<Response<CoinDetailsModel>>{
        return object : Observer<Response<CoinDetailsModel>>{
            override fun onSubscribe(d: Disposable) {
                TODO("Not yet implemented")
            }

            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                TODO("Not yet implemented")
            }

            override fun onNext(t: Response<CoinDetailsModel>) {
                TODO("Not yet implemented")
            }

        }
    }
}