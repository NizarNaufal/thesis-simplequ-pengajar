package com.example.thesis.utils.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.thesis.databinding.ItemSantriBinding
import com.example.thesis.utils.loadImageWithCache
import com.example.thesis.utils.models.DatumModel

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemSantriBinding.bind(itemView)


    @SuppressLint("SetTextI18n")
    fun bindTo(data: DatumModel) {
        with(binding) {
            itemView.apply {
                ivItemSantri.loadImageWithCache(data.img_preview)
                tvSantriAnda.text = data.name
            }
        }
    }
}