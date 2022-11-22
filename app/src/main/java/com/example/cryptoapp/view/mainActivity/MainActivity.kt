package com.example.cryptoapp.view.mainActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.model.CoinModel
import com.example.cryptoapp.model.coinEntities.CoinEntity
import com.example.cryptoapp.utils.Utilities.Companion.checkConnectionInternet
import com.example.cryptoapp.utils.toDataBase
import com.example.cryptoapp.view.BaseActivity
import com.example.cryptoapp.view.loginActivity.LoginActivity
import com.example.cryptoapp.view.mainActivity.adapter.CoinAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.math.min

class MainActivity : BaseActivity() {

    private lateinit var coinAdapter: CoinAdapter
    private var latestCoinList = mutableListOf<CoinEntity>()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val editor by lazy {
        preferences.edit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        initHomeRecyclerView()


    }

    private fun initComponents() {
        coinAdapter = CoinAdapter(latestCoinList)
        binding.rvLatestCoins.adapter = coinAdapter
        binding.rvLatestCoins.layoutManager = LinearLayoutManager(this)
    }

    private fun initHomeRecyclerView() {
        latestCoinList.clear()
        loadRecyclerView(checkConnectionInternet(this))
    }

    private fun loadRecyclerView(connection: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            // I will refactor this when the list of latest coins is empty (I will create a custom view to notify this)
            latestCoinList.addAll(if (connection) getLatestCoinsFromNetwork() else getLatestCoinsFromDB())

            if (connection && updateDB()) latestCoinList.forEach {
                // Update DB only if 40' has passed and there is connection to internet
                getInstanceRoom().getCoinDao().insertCoinToDB(it)
            }

            runOnUiThread {
                coinAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun getLatestCoinsFromDB() = getInstanceRoom().getCoinDao().getLatestCoin()

    private suspend fun getLatestCoinsFromNetwork() =
        getAPIService().getLatestCoins().body()?.data?.map { it.toDataBase() } ?: emptyList()

    // This function check time elapsed since last DB update. If it's above 40', I will update the DB
    private fun updateDB(): Boolean {
        var differenceTime = Date().time - preferences.getLong("lastUpdate", 0)
        var minutes: Long = (differenceTime / 1000) / 60

        return if (minutes >= 40) {
            // Update time on preferences
            editor.putLong("lastUpdate", Date().time).apply()
            Log.d("mainTimer", "It's been ${preferences.getLong("lastUpdate", 2F.toLong())}'")
            true
        } else {
            Log.d("mainTimer", "It's below 40'")
            false
        }
    }

    override fun onBackPressed() {
        onConfirmLogout()
    }

    private fun onConfirmLogout() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(resources.getString(R.string.log_out))
            .setTitle(resources.getString(R.string.title_log_out))
            .setCancelable(true)
            .setPositiveButton(resources.getString(R.string.yes)) { _, _ ->
                onLogout()
            }
            .setNegativeButton(resources.getString(R.string.no)) { dialog, _ ->
                // Dismiss the dialog
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    private fun onLogout() {
        editor.putBoolean("keepCredentials", false).apply()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}