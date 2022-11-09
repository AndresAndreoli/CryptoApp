package com.example.cryptoapp.model

data class CoinModel(
    private val status: Status,
    private val data: CoinData
    )

data class Status(
    private val error_code: Int?,
    private val error_message: String?
    )

data class CoinData(
    private val id: Int,
    private val name: String
    )
