package com.example.cryptoapp.view.splashActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.cryptoapp.R
import com.example.cryptoapp.view.loginActivity.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
            }, 4000) }
}