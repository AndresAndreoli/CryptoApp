package com.example.cryptoapp.app.presentation.view.mainActivity.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.ItemCoinBinding
import com.example.cryptoapp.app.framework.db.coinEntities.CoinEntity
import java.text.DecimalFormat

class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemCoinBinding.bind(itemView)

    fun render(item: CoinEntity) {
        binding.apply {
            tvTitle.text = item.name
            tvPrice.text = (DecimalFormat("#.#").format(item.price))
            tvSymbol.text = item.symbol
        }
    }
}