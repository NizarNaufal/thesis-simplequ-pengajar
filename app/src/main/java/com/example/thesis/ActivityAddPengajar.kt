package com.example.thesis

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityAddPengajarBinding

class ActivityAddPengajar: BaseActivity<ActivityAddPengajarBinding>(ActivityAddPengajarBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnVerifyConfirm.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_success_add_pengajar)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val dialogBtn = dialog.findViewById<TextView>(R.id.tvOk)
        dialogBtn.setOnClickListener {
            dialog.dismiss()
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(this)
            }
        }
        dialog.show()
    }
}