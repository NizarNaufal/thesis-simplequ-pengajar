package com.example.thesis

import android.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityPrestasiSantriBinding
import com.example.thesis.utils.DatumCallback
import com.example.thesis.utils.HomeViewModel
import com.example.thesis.utils.adapter.DataAdapter
import com.example.thesis.utils.models.DatumModel
import kotlinx.android.synthetic.main.item_list_santri.view.*

class ActivityPrestasiSantri : BaseActivity<ActivityPrestasiSantriBinding>(ActivityPrestasiSantriBinding::inflate),DatumCallback {

    private lateinit var viewModel: HomeViewModel
    var list_of_items = arrayOf("Jilid 1", "Jilid 2", "Jilid 3")
    private val REQUEST_PICK_SANTRI = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }

        val listMovie = viewModel.getListPrestasiSantri()
        setupRecyclerView(listMovie)
        setupSpinner()
        setupButtonClick()
        setupUi()
    }
    private fun setupUi(){
        binding.btnVerifyConfirm.setOnClickListener {

        }
        binding.ivList.setOnClickListener {
            val intent = Intent(this, ActivityListSantri::class.java)
            startActivityForResult(intent, REQUEST_PICK_SANTRI)

        }
    }
    private fun setupButtonClick(){
        binding.clUlang.setOnClickListener {
            binding.clUlang.setBackgroundResource(com.example.thesis.R.drawable.bg_border_radius_green)
            binding.clNaik.setBackgroundResource(com.example.thesis.R.drawable.bg_border_radius)
        }
        binding.clNaik.setOnClickListener {
            binding.clUlang.setBackgroundResource(com.example.thesis.R.drawable.bg_border_radius)
            binding.clNaik.setBackgroundResource(com.example.thesis.R.drawable.bg_border_radius_green)
        }
    }
    private fun setupSpinner(){
        val aa = ArrayAdapter(this, R.layout.simple_spinner_item, list_of_items)
        aa.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = aa
    }
    private fun setupRecyclerView(data: List<DatumModel>) {
        with(binding) {
            rvCargo.apply {
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter = DataAdapter(this@ActivityPrestasiSantri)
            }.also {
                it.adapter.let { adapter ->
                    when (adapter) {
                        is DataAdapter -> {
                            adapter.setData(data)
                        }
                    }
                }
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_PICK_SANTRI -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result: DatumModel? = data?.getParcelableExtra("data")
                    result?.let { onPickUpSantriResult(it) }
                    result?.let { onItemClicked(it) }
                }

            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun onPickUpSantriResult(data: DatumModel){

    }
    override fun onItemClicked(data: DatumModel) {

    }
}