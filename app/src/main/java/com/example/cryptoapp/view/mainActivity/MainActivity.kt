package com.example.cryptoapp.view.mainActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.cryptoapp.R
import com.example.cryptoapp.view.BaseActivity
import com.example.cryptoapp.view.loginActivity.LoginActivity
import com.example.cryptoapp.viewModel.MainViewModel

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Testing coin requests (this will be remove in the future)
        viewModel.getLatestCoins()
        viewModel.getCoinById(1)
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