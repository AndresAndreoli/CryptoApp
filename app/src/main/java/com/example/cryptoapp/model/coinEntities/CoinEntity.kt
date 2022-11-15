package com.example.cryptoapp.model.coinEntities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "latest_coin_table")
data class CoinEntity(
    @PrimaryKey() val id: Int?,
    val name: String?,
    val symbol: String?,
    val slug: String?,
    val numMarketPairs: Int?,
    val dateAdded: String?,
    val tags: ArrayList<String>,
    val maxSupply: Long?,
    val totalSupply: Float?,
    val lastUpdated: String?
)