package com.example.thesis.utils.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DatumModel(
    var id: String,
    var name: String,
    var desc: String,
    var img_preview: String
) : Parcelable