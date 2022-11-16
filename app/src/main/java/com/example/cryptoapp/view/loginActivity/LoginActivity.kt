package com.example.cryptoapp.view.loginActivity

import android.content.Intent
import android.os.Bundle
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityLoginBinding
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
        if (username.isEmpty() || password.isEmpty())
            // Show information message about empty fields
            showSnackBar(resources.getString(R.string.emptyFields), resources.getColor(R.color.red))
        else if (preferences.getString("username", "") != username || (preferences.getString("password", "") != password)){
            // Show information message about incorrect credentials
            showSnackBar(resources.getString(R.string.credentialsIncorrect), resources.getColor(R.color.red))
        } else {
            preferences.edit().putBoolean("keepCredentials", binding.cbRemember.isChecked).apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    // displays a generic message
    private fun showSnackBar(message: String, color: Int) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(color)
            .show()
    }
}