package com.example.cryptoapp.model

import com.google.gson.annotations.SerializedName

// I know i should create individual classes for each model
data class CoinDetails (
    @SerializedName("id"                               ) var id                            : Int?                       = null,
    @SerializedName("name"                             ) var name                          : String?                    = null,
    @SerializedName("symbol"                           ) var symbol                        : String?                    = null,
    @SerializedName("category"                         ) var category                      : String?                    = null,
    @SerializedName("description"                      ) var description                   : String?                    = null,
    @SerializedName("slug"                             ) var slug                          : String?                    = null,
    @SerializedName("logo"                             ) var logo                          : String?                    = null,
    @SerializedName("subreddit"                        ) var subreddit                     : String?                    = null,
    @SerializedName("notice"                           ) var notice                        : String?                    = null,
    @SerializedName("tags"                             ) var tags                          : ArrayList<String>          = arrayListOf(),
    @SerializedName("urls"                             ) var urls                          : Urls?                      = Urls(),
    @SerializedName("date_added"                       ) var dateAdded                     : String?                    = null,
    @SerializedName("twitter_username"                 ) var twitterUsername               : String?                    = null,
    @SerializedName("is_hidden"                        ) var isHidden                      : Int?                       = null,
    @SerializedName("date_launched"                    ) var dateLaunched                  : String?                    = null,
    @SerializedName("self_reported_circulating_supply" ) var selfReportedCirculatingSupply : String?                    = null,
    @SerializedName("self_reported_tags"               ) var selfReportedTags              : String?                    = null,
    @SerializedName("self_reported_market_cap"         ) var selfReportedMarketCap         : String?                    = null
)

data class Urls (
    @SerializedName("website"       ) var website      : ArrayList<String> = arrayListOf(),
    @SerializedName("twitter"       ) var twitter      : ArrayList<String> = arrayListOf(),
    @SerializedName("message_board" ) var messageBoard : ArrayList<String> = arrayListOf(),
    @SerializedName("chat"          ) var chat         : ArrayList<String> = arrayListOf(),
    @SerializedName("facebook"      ) var facebook     : ArrayList<String> = arrayListOf(),
    @SerializedName("explorer"      ) var explorer     : ArrayList<String> = arrayListOf(),
    @SerializedName("reddit"        ) var reddit       : ArrayList<String> = arrayListOf(),
    @SerializedName("technical_doc" ) var technicalDoc : ArrayList<String> = arrayListOf(),
    @SerializedName("source_code"   ) var sourceCode   : ArrayList<String> = arrayListOf(),
    @SerializedName("announcement"  ) var announcement : ArrayList<String> = arrayListOf()
)