package com.example.cryptoapp.view.mainActivity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.model.coinEntities.CoinEntity

class CoinAdapter(
    var coins: List<CoinEntity>,
    val callback: (id: Int, price: Double, supply: Long) -> Unit
) : RecyclerView.Adapter<CoinViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = coins[position]
        holder.render(item)

        holder.binding.itemCoin.setOnClickListener {
            callback(
                   coins[position].id ?: -1,
                      (coins[position].price ?: -1) as Double,
                coins[position].maxSupply ?: -1
            )
        }
    }

    override fun getItemCount() = coins.size
}