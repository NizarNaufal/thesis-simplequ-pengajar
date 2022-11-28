package com.example.thesis

import android.content.Intent
import android.os.Bundle
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivitySuccessCreateAccountBinding

class ActivitySuccessPage : BaseActivity<ActivitySuccessCreateAccountBinding>(ActivitySuccessCreateAccountBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnCreatePassword.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(this)
            }
        }
    }
}