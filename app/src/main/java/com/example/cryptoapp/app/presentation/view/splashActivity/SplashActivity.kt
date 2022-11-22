package com.example.cryptoapp.app.presentation.view.splashActivity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptoapp.R
import com.example.cryptoapp.app.presentation.view.BaseActivity
import com.example.cryptoapp.app.presentation.view.loginActivity.LoginActivity
import com.example.cryptoapp.app.presentation.view.mainActivity.MainActivity
import java.util.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            saveCredentialsOnPreferences()

            if (preferences.getBoolean("keepCredentials", false))
                // User keeps your session open
                startActivity(Intent(this, MainActivity::class.java))
            else
                // User doesn't keep your session open
                startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 4000)
    }

    private fun saveCredentialsOnPreferences(){
        if (credentialsIsEmpty()){
            val editor = preferences.edit()
            editor.putString("username", "andres")
            editor.putString("password", "andreoli")
            editor.putBoolean("keepCredentials", false)
            editor.putLong("lastUpdate", 0)
            editor.apply()
        }
    }

    // This function will let us know if there are data on the preferences
    private fun credentialsIsEmpty(): Boolean {
        return (preferences.getString("username", null).isNullOrEmpty())
                || (preferences.getString("password", null).isNullOrEmpty())
    }
}