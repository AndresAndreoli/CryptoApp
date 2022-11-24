package com.example.cryptoapp.view.mainActivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.cryptoapp.databinding.ActivityCoinDescriptionBinding
import com.example.cryptoapp.model.CoinDetails
import com.example.cryptoapp.view.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinDescriptionActivity : BaseActivity() {

    private var _binding: ActivityCoinDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCoinDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
    }

    private fun initComponents() {
        val coinId = intent.extras?.get("coinID")

        if (coinId == -1) closeActivity() else getCoinDetails(coinId as Int)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.tvContentWeb.setOnClickListener {
            // It will open the coin website
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.tvContentWeb.text.toString()))
            startActivity(intent)
        }
    }

    private fun getCoinDetails(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = getAPIService().getCoinById(id).body()?.data?.get(id)
            runOnUiThread {
                loadContent(response)
            }
        }
    }

    private fun loadContent(coin: CoinDetails?) {
        if (coin == null) {
            closeActivity()
        } else {
            val supply = intent.extras?.get("supply")
            binding.apply {
                tvName.text = coin.name
                tvDescription.text = coin.description
                Glide.with(this@CoinDescriptionActivity)
                    .load(coin.logo)
                    .into(ivLogo)
                tvContentSymbol.text = coin.symbol
                tvContentWeb.text = coin.urls?.website?.get(0) ?: "No found"
                tvContentDateAdded.text = coin.dateAdded?.subSequence(0,10)
                tvContentPrice.text = intent.extras?.get("price").toString()
                tvContentSupply.text = if (supply == -1L) "No information" else supply.toString()
            }
        }
    }

    private fun closeActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}