package com.example.thesis.utils

import androidx.lifecycle.ViewModel
import com.example.thesis.utils.models.DatumModel

class HomeViewModel : ViewModel() {

    fun getListPrestasiSantri(): List<DatumModel> = DatumDummy.generateDataMovieDummy()
    fun getListPrestasiPengajar(): List<DatumModel> = DatumDummy.generateDataPengajarDummy()

}