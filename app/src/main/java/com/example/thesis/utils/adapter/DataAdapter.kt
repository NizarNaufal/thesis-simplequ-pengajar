package com.example.thesis.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thesis.R
import com.example.thesis.utils.DatumCallback
import com.example.thesis.utils.models.DatumModel
import kotlinx.android.synthetic.main.item_list_santri.view.*
import java.util.*

class DataAdapter(private val callback: DatumCallback) :
    RecyclerView.Adapter<DataViewHolder>() {
    private val listData = ArrayList<DatumModel>()
    var selectedItems = mutableListOf(-1)

    fun setData(data: List<DatumModel>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_santri, parent, false)
        )

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindTo(listData[position])
        holder.itemView.setBackgroundResource(R.drawable.bg_card_white)
        selectedItems.forEach {
            if (it == position) {
                holder.itemView.setBackgroundResource(R.drawable.bg_border_radius_green)
            }else{
                holder.itemView.setBackgroundResource(R.drawable.bg_card_white)
            }
        }
        holder.itemView.setOnClickListener {
            callback.onItemClicked(listData[position])
            selectedItems.add(position)
            selectedItems.forEach { selectedItem ->
                notifyItemChanged(selectedItem)
            }
        }
    }

}