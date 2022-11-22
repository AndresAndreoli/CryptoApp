package com.example.cryptoapp.utils

import com.example.cryptoapp.model.CoinModel
import com.example.cryptoapp.app.framework.db.coinEntities.CoinEntity

// This will let me convert LatestCoin type data to CoinModel type data
fun CoinModel.toDataBase() =
    CoinEntity(
        this.id,
        this.name,
        this.symbol,
        this.slug,
        this.numMarketPairs,
        this.dateAdded,
        this.maxSupply,
        this.totalSupply,
        this.lastUpdated,
        this.quote?.USD?.price
    )

// This will let me convert CoinModel type data to LatestCoin type data
fun CoinEntity.toModel() =
    CoinModel(
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