package com.example.cryptoapp.Utils

import com.example.cryptoapp.model.LatestCoin
import com.example.cryptoapp.model.coinEntities.CoinEntity

// This will let me convert LatestCoin type data to CoinModel type data
fun LatestCoin.toDataBase() =
    CoinEntity(
        this.id,
        this.name,
        this.symbol,
        this.slug,
        this.numMarketPairs,
        this.dateAdded,
        this.maxSupply,
        this.totalSupply,
        this.lastUpdated
    )