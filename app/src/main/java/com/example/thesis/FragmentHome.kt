package com.example.thesis

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.thesis.common.BaseFragment
import com.example.thesis.databinding.FragmentHomeBinding

class FragmentHome : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBackgroundPrestasiSantri.setOnClickListener {
            Intent(requireContext(), ActivityPrestasiSantri::class.java).apply {
                startActivity(this)
            }
        }
        binding.clPintasan.setOnClickListener {
            Intent(requireContext(), ActivityListPengajar::class.java).apply {
                startActivity(this)
            }
        }

        binding.clPintasanListSantri.setOnClickListener {
            Intent(requireContext(), ActivityListSantri::class.java).apply {
                startActivity(this)
            }
        }
    }

}