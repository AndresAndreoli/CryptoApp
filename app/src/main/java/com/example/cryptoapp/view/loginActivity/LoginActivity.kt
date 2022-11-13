package com.example.cryptoapp.view.loginActivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityLoginBinding
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.view.BaseActivity
import com.example.cryptoapp.view.mainActivity.MainActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : BaseActivity() {

    private var _binding : ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btnLogin.setOnClickListener {
            loginUser(binding.etUsernameLogin.text.toString(), binding.etPasswordLogin.text.toString())
        }
    }

    private fun loginUser(username: String, password: String){
        if (username.isEmpty() && password.isEmpty())
            showSnackBar("Complete both fields", resources.getColor(R.color.red))
        else if (preferences.getString("username", "") == username && (preferences.getString("password", "") == password)){
            preferences.edit().putBoolean("keepCredentials", binding.cbRemember.isChecked).apply()
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            showSnackBar("Your username or password is incorrect", resources.getColor(R.color.red))
        }
    }

    // displays a generic message
    private fun showSnackBar(message: String, color: Int) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(color)
            .show()
    }
}