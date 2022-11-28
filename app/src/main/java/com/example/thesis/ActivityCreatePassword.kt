package com.example.thesis

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityCreatePasswordBinding
import com.example.thesis.utils.CustomTextWatcher
import com.example.thesis.utils.DatumDummy
import com.example.thesis.utils.TextWatcherTextChange

class ActivityCreatePassword : BaseActivity<ActivityCreatePasswordBinding>(ActivityCreatePasswordBinding::inflate),
    TextWatcherTextChange {

    private var validation: AwesomeValidation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbarVerification)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        setupValidation()

        CustomTextWatcher().registerEditText(binding.etEmail).setCallBackOnTextChange(this)
        CustomTextWatcher().registerEditText(binding.etPassword).setCallBackOnTextChange(this)

        binding.btnCreatePassword.setOnClickListener {
            validation?.let {
                if (it.validate()){
                    Intent(this, ActivitySuccessPage::class.java).apply {
                        startActivity(this)
                    }
                }
            }
        }
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
        binding.btnCreatePassword.setBackgroundResource(R.drawable.btn_enabled)
        binding.btnCreatePassword.isEnabled = true
    }
    private fun disableBtnConfirm(){
        binding.btnCreatePassword.setBackgroundResource(R.drawable.btn_disabled)
        binding.btnCreatePassword.isEnabled = false
    }


    private fun setupValidation(){
        validation = AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT)
        validation?.apply {
            setTextInputLayoutErrorTextAppearance(R.style.TextInputLayoutErrorStyle)
            addValidation(
                this@ActivityCreatePassword,
                R.id.tlPassword,
                DatumDummy.PASSWORD_PATTERN,
                R.string.err_password)
            addValidation(
                this@ActivityCreatePassword,
                R.id.tlPasswordLater,
                R.id.tlPassword,
                R.string.err_confirm_password)
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