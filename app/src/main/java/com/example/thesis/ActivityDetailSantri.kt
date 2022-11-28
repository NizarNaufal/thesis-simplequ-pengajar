package com.example.thesis

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityDetailSantriBinding
import com.example.thesis.utils.loadImageWithCache
import com.example.thesis.utils.models.DatumModel
import com.google.android.material.tabs.TabLayout

class ActivityDetailSantri : BaseActivity<ActivityDetailSantriBinding>(
    ActivityDetailSantriBinding::inflate){

    private var currentPosition = -1
    private lateinit var datumModel: DatumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTabLayout()
        fetchActivity()
        datumModel = intent.getParcelableExtra("data")!!
        binding.ivIconDriver.loadImageWithCache(datumModel.img_preview)
        binding.tvVehicleType.text = datumModel.name
    }

    private fun initTabLayout() {
        with(binding) {
            tabLayout.apply {
                addTab(tabLayout.newTab().setText("Aktivitas"))
                addTab(tabLayout.newTab().setText("Profil"))
                addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        when (tab?.position) {
                            0 -> {
                                fetchActivity()
                            }
                            1 -> {
                                fetchProfile()
                            }
                        }
                        currentPosition = tab?.position ?: 0
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
                    override fun onTabReselected(tab: TabLayout.Tab?) = Unit
                })
            }
        }
    }

    fun fetchActivity(){
        binding.includeAktivitas.root.visibility = View.VISIBLE
        binding.includeProfil.root.visibility = View.GONE
        binding.clChange.visibility = View.GONE
        binding.includeAktivitas.show.setOnClickListener { view ->
            if (binding.includeAktivitas.cardGroup.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(binding.includeAktivitas.baseCardview, AutoTransition())
                binding.includeAktivitas.cardGroup.visibility = View.GONE
                binding.includeAktivitas.show.setImageResource(android.R.drawable.arrow_down_float)
            } else {
                TransitionManager.beginDelayedTransition(binding.includeAktivitas.baseCardview, AutoTransition())
                binding.includeAktivitas.cardGroup.visibility = View.VISIBLE
                binding.includeAktivitas.show.setImageResource(android.R.drawable.arrow_up_float)
            }
        }

        binding.includeAktivitas.show1.setOnClickListener { view ->
            if (binding.includeAktivitas.cardGroup1.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(binding.includeAktivitas.baseCardviewAdab, AutoTransition())
                binding.includeAktivitas.cardGroup1.visibility = View.GONE
                binding.includeAktivitas.show1.setImageResource(android.R.drawable.arrow_down_float)
            } else {
                TransitionManager.beginDelayedTransition(binding.includeAktivitas.baseCardviewAdab, AutoTransition())
                binding.includeAktivitas.cardGroup1.visibility = View.VISIBLE
                binding.includeAktivitas.show1.setImageResource(android.R.drawable.arrow_up_float)
            }
        }

        binding.includeAktivitas.show2.setOnClickListener { view ->
            if (binding.includeAktivitas.cardGroup2.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(binding.includeAktivitas.baseCardviewHafalan, AutoTransition())
                binding.includeAktivitas.cardGroup2.visibility = View.GONE
                binding.includeAktivitas.show2.setImageResource(android.R.drawable.arrow_down_float)
            } else {
                TransitionManager.beginDelayedTransition(binding.includeAktivitas.baseCardviewHafalan, AutoTransition())
                binding.includeAktivitas.cardGroup2.visibility = View.VISIBLE
                binding.includeAktivitas.show2.setImageResource(android.R.drawable.arrow_up_float)
            }
        }
    }

    fun fetchProfile(){
        binding.includeAktivitas.root.visibility = View.GONE
        binding.includeProfil.root.visibility = View.VISIBLE
        binding.clChange.visibility = View.VISIBLE
        binding.btnChange.setOnClickListener {
            Intent(this, ActivityEditPengajar::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnDelete.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_delete_pengajar)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val dialogBtn = dialog.findViewById<Button>(R.id.tvOk)
        val dialogBack = dialog.findViewById<Button>(R.id.tvBack)
        dialogBack.setOnClickListener {
            dialog.dismiss()
        }
        dialogBtn.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(this)
            }
        }
        dialog.show()
    }
}