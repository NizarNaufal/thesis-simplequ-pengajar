package com.example.thesis

import android.os.Bundle
import android.view.View
import com.example.thesis.common.BaseFragment
import com.example.thesis.databinding.FragmentClassBinding

class FragmentClass : BaseFragment<FragmentClassBinding>(FragmentClassBinding::inflate){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}