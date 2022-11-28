package com.example.thesis

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityRegisterBinding
import com.example.thesis.utils.CustomTextWatcher
import com.example.thesis.utils.TextWatcherTextChange

class ActivityRegister : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate),TextWatcherTextChange {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTermConditionText()

        CustomTextWatcher().registerEditText(binding.etEmail).setCallBackOnTextChange(this)
        CustomTextWatcher().registerEditText(binding.etNoStatik).setCallBackOnTextChange(this)
        CustomTextWatcher().registerEditText(binding.etAddressLembaga).setCallBackOnTextChange(this)
        CustomTextWatcher().registerEditText(binding.etName).setCallBackOnTextChange(this)
        CustomTextWatcher().registerEditText(binding.etLembaga).setCallBackOnTextChange(this)
        CustomTextWatcher().registerEditText(binding.etNameKepalaLembaga).setCallBackOnTextChange(this)

        if (binding.etNoStatik.text.toString() == "112349712912"){
            binding.btnCheckData.isEnabled = true
            binding.btnCheckData.setBackgroundResource(R.drawable.btn_enabled)
            binding.btnCheckData.setOnClickListener {
                binding.ivChecklist.visibility = View.VISIBLE
                binding.btnCheckData.visibility = View.GONE
            }
        }else if (binding.etNoStatik.text.toString().isNotEmpty()){
            binding.btnCheckData.isEnabled = true
            binding.ivChecklist.visibility = View.GONE
            binding.btnCheckData.setBackgroundResource(R.drawable.btn_enabled)
            binding.btnCheckData.setOnClickListener {
                showDialog()
            }
        }else{
            binding.ivChecklist.visibility = View.GONE
            binding.btnCheckData.isEnabled = false
            binding.btnCheckData.setBackgroundResource(R.drawable.btn_disabled)
            binding.btnCheckData.visibility = View.VISIBLE
        }

        binding.btnLogin.setOnClickListener {
            Intent(this, ActivityOTP::class.java).apply {
                putExtra("email",binding.etEmail.text.toString())
                startActivity(this)
            }
        }

    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_lembaga_not_found)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val dialogBtn = dialog.findViewById<TextView>(R.id.tvOk)
        dialogBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun setTermConditionText() {
        val textTermCondition =
            SpannableString("Dengan melanjutkan, saya setuju dengan syarat dan ketentuan dari Badko dibawah ini. Syarat dan ketentuan")
        val textSpecial = "Syarat dan ketentuan"
        val startIndex = textTermCondition.toString().indexOf(textSpecial)
        val lastIndex = startIndex + textSpecial.length
        val linkSpan = object : ClickableSpan() {
            override fun onClick(view: View) {

            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(this@ActivityRegister, R.color.green)
                ds.isUnderlineText = true
                ds.isFakeBoldText = true
            }
        }
        textTermCondition.setSpan(linkSpan, startIndex, lastIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvTermsAndConditions.text = textTermCondition
        binding.tvTermsAndConditions.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun onTextChanged(editText: EditText?, p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (validateForm(binding.etEmail.text.toString(),binding.etName.text.toString(),
                binding.etLembaga.text.toString(),binding.etAddressLembaga.text.toString(),
                binding.etNameKepalaLembaga.text.toString(),binding.etNoStatik.text.toString())){
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

    private fun validateForm(email: String, name: String,lembaga: String, address: String,nameKepalaLembaga: String, noStatik: String):Boolean{
        return email.isNotEmpty() && name.isNotEmpty() && lembaga.isNotEmpty() && address.isNotEmpty() && nameKepalaLembaga.isNotEmpty() && noStatik.isNotEmpty()
    }
}