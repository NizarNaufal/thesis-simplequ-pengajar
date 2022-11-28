package com.example.thesis

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
import android.widget.EditText
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityLoginBinding
import com.example.thesis.utils.CustomTextWatcher
import com.example.thesis.utils.DatumDummy
import com.example.thesis.utils.TextWatcherTextChange

class ActivityLogin : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),TextWatcherTextChange {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(true)
        }
        setSupportActionBar(binding.toolbarVerification)
        val validation = AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT)
        validation.setTextInputLayoutErrorTextAppearance(R.style.TextInputLayoutErrorStyle)
        validation.addValidation(this, R.id.tlEmail, Patterns.EMAIL_ADDRESS, R.string.err_email)
        validation.addValidation(this, R.id.tlPassword, DatumDummy.PASSWORD_PATTERN, R.string.err_password)
        binding.btnLogin.setOnClickListener {
            if(validation.validate()) {
                Intent(this, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(this)
                }
            }
        }

        CustomTextWatcher().registerEditText(binding.etEmail).setCallBackOnTextChange(this)
        CustomTextWatcher().registerEditText(binding.etPassword).setCallBackOnTextChange(this)

    }
    private fun validateForm(newPassword: String, confirmPassword: String):Boolean{
        return newPassword.isNotEmpty() && confirmPassword.isNotEmpty()
    }

    override fun onTextChanged(editText: EditText?, p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (validateForm(binding.etEmail.text.toString(),binding.etPassword.text.toString())){
            enableBtnConfirm()
        }else{
            disableBtnConfirm()
        }

    }

    private fun enableBtnConfirm(){
        binding.btnLogin.setBackgroundResource(R.drawable.btn_enabled)
        binding.btnLogin.isEnabled = true
    }
    private fun disableBtnConfirm(){
        binding.btnLogin.setBackgroundResource(R.drawable.btn_disabled)
        binding.btnLogin.isEnabled = false
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