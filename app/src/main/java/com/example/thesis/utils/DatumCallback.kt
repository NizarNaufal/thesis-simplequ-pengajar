package com.example.thesis.utils

import com.example.thesis.utils.models.DatumModel

interface DatumCallback  {
    fun onItemClicked(data: DatumModel)
}