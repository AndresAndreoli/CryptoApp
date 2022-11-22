package com.example.cryptoapp.core.interactors

import com.example.cryptoapp.core.data.CoinRepository

class GetLatestCoins(private val repository: CoinRepository) {
    suspend operator fun invoke() = repository.getLatestCoins()
}