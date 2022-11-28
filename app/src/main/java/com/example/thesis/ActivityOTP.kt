package com.example.thesis

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityOtpBinding
import com.example.thesis.utils.hideKeyboard

class ActivityOTP : BaseActivity<ActivityOtpBinding>(ActivityOtpBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbarVerification)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        val email = intent.getStringExtra("email")?:""
        binding.tvDescCodeVerification.text = getString(R.string.str_email_input,email)
        binding.otpView.addTextChangedListener (object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(count < 4 || binding.otpView.text?.trim()?.isEmpty() == true){
                    binding.otpView.requestFocus()
                    binding.btnVerifyConfirm.setBackgroundResource(R.drawable.btn_disabled)
                    binding.btnVerifyConfirm.isEnabled = false
                }
                if(count >=1){
                   binding.otpView.requestFocus()
                    binding.etOtpFailed.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        binding.otpView.setOtpCompletionListener { otp ->
            if (binding.otpView.text.toString() == "5810"){
                Intent(this, ActivityCreatePassword::class.java).apply {
                    startActivity(this)
                }
            }else{
                binding.etOtpFailed.text = "Gagal,Kode Otp Salah!"
                binding.etOtpFailed.visibility = View.VISIBLE
            }
            binding.btnVerifyConfirm.setBackgroundResource(R.drawable.btn_enabled)
            binding.btnVerifyConfirm.isEnabled = true
            binding.btnVerifyConfirm.setOnClickListener {
                binding.otpView.hideKeyboard()
                binding.etOtpFailed.visibility = View.GONE
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                onBackPressed()
                true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }
}