package com.example.cryptoapp.model

import com.google.gson.annotations.SerializedName

// I know i should create individual classes for each model
data class BaseResponse<T>(
    val status: StatusResponse,
    val data: T
)

data class StatusResponse (
    @SerializedName("timestamp"     ) var timestamp    : String? = null,
    @SerializedName("error_code"    ) var errorCode    : Int?    = null,
    @SerializedName("error_message" ) var errorMessage : String? = null,
    @SerializedName("elapsed"       ) var elapsed      : Int?    = null,
    @SerializedName("credit_count"  ) var creditCount  : Int?    = null,
    @SerializedName("notice"        ) var notice       : String? = null
)