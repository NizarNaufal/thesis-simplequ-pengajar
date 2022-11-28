package com.example.thesis

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thesis.common.BaseActivity
import com.example.thesis.databinding.ActivityListPengajarBinding
import com.example.thesis.utils.DatumCallback
import com.example.thesis.utils.HomeViewModel
import com.example.thesis.utils.adapter.DataListSantriAdapter
import com.example.thesis.utils.models.DatumModel

class ActivityListPengajar : BaseActivity<ActivityListPengajarBinding>(ActivityListPengajarBinding::inflate),
    DatumCallback {
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbarVerification)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }
        val listMovie = viewModel.getListPrestasiPengajar()
        setupRecyclerView(listMovie)

        binding.btnVerifyConfirm.isEnabled = true
        binding.btnVerifyConfirm.setOnClickListener {
            Intent(this, ActivityAddPengajar::class.java).apply {
                startActivity(this)
            }
        }
    }
    private fun setupRecyclerView(data: List<DatumModel>) {
        with(binding) {
            rvListSantri.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = DataListSantriAdapter(this@ActivityListPengajar)
            }.also {
                it.adapter.let { adapter ->
                    when (adapter) {
                        is DataListSantriAdapter -> {
                            adapter.setData(data)
                        }
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DatumModel) {
        Intent(this, ActivityDetailPengajar::class.java).apply {
            putExtra("data",data)
            startActivity(this)
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