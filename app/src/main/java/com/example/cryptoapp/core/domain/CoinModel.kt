package com.example.cryptoapp.model

import com.google.gson.annotations.SerializedName

// I know i should create individual classes for each model
data class CoinModel (
    @SerializedName("id"                               ) var id                            : Int?              = null,
    @SerializedName("name"                             ) var name                          : String?           = null,
    @SerializedName("symbol"                           ) var symbol                        : String?           = null,
    @SerializedName("slug"                             ) var slug                          : String?           = null,
    @SerializedName("num_market_pairs"                 ) var numMarketPairs                : Int?              = null,
    @SerializedName("date_added"                       ) var dateAdded                     : String?           = null,
    @SerializedName("max_supply"                       ) var maxSupply                     : Long?             = null,
    @SerializedName("total_supply"                     ) var totalSupply                   : Float?            = null,
    @SerializedName("last_updated"                     ) var lastUpdated                   : String?           = null,
    @SerializedName("quote"                            ) var quote                         : Quote?            = Quote()
)

data class USD (
    @SerializedName("price"                    ) var price                 : Double? = null,
    @SerializedName("volume_24h"               ) var volume24h             : Double? = null,
    @SerializedName("volume_change_24h"        ) var volumeChange24h       : Double? = null,
    @SerializedName("percent_change_1h"        ) var percentChange1h       : Double? = null,
    @SerializedName("percent_change_24h"       ) var percentChange24h      : Double? = null,
    @SerializedName("percent_change_7d"        ) var percentChange7d       : Double? = null,
    @SerializedName("percent_change_30d"       ) var percentChange30d      : Double? = null,
    @SerializedName("percent_change_60d"       ) var percentChange60d      : Double? = null,
    @SerializedName("percent_change_90d"       ) var percentChange90d      : Double? = null,
    @SerializedName("market_cap"               ) var marketCap             : Double? = null,
    @SerializedName("market_cap_dominance"     ) var marketCapDominance    : Double? = null,
    @SerializedName("fully_diluted_market_cap" ) var fullyDilutedMarketCap : Double? = null,
    @SerializedName("tvl"                      ) var tvl                   : String? = null,
    @SerializedName("last_updated"             ) var lastUpdated           : String? = null
)

data class Quote (
    @SerializedName("USD" ) var USD : USD? = USD()
)