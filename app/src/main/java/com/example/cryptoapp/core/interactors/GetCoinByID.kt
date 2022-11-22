package com.example.cryptoapp.core.interactors

import com.example.cryptoapp.core.data.CoinRepository

class GetCoinByID(private val repository: CoinRepository) {
    suspend operator fun invoke(id: Int) = repository.getCoinByID(id)
}