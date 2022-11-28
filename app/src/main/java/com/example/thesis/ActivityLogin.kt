package com.example.thesis

import android.content.Intent
import android.os.Bundle
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityLoginBinding

class ActivityLogin : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(true)
            title = "Masuk"
        }
        binding.btnLogin.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}