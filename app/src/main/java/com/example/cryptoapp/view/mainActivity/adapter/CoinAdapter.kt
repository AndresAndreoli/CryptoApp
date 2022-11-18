package com.example.cryptoapp.view.mainActivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ItemCoinBinding
import com.example.cryptoapp.model.CoinModel
import com.example.cryptoapp.model.coinEntities.CoinEntity
import java.text.DecimalFormat

class CoinAdapter(var coins: List<CoinEntity>): RecyclerView.Adapter<CoinViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent,false)
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = coins[position]
        holder.render(item)
    }

    override fun getItemCount() = coins.size
}