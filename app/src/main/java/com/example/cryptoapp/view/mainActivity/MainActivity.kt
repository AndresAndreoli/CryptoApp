package com.example.cryptoapp.view.mainActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.cryptoapp.R
import com.example.cryptoapp.Utils.toDataBase
import com.example.cryptoapp.model.LatestCoin
import com.example.cryptoapp.view.BaseActivity
import com.example.cryptoapp.view.loginActivity.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Testing the code (This will be changed)
        getLatestCoins()
    }

    private fun getLatestCoins() {
        CoroutineScope(Dispatchers.IO).launch {
            // This wont the final code. I will refactor this code with the next ticket
            insertLatestCoinsToDB(getAPIService().getLatestCoins().body()?.data ?: emptyList())
        }
    }

    private suspend fun insertLatestCoinsToDB(coins: List<LatestCoin>){
        if (coins.isNotEmpty()){
            coins.forEach{
                getInstanceRoom().getCoinDao().insertCoinToDB(it.toDataBase())
            }
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
            .setPositiveButton(resources.getString(R.string.yes)) { _,_ ->
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
        preferences.edit().putBoolean("keepCredentials", false).apply()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}