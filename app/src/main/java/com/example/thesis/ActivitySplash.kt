package com.example.thesis

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivitySplashBinding

class ActivitySplash : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, ActivityFirstPage::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(this)
            }

        }, 1500)
    }
}