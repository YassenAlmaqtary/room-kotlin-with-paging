//package com.example.paging_datas
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.paging_datas.room_data.model.Device
//
//class ListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
//    LayoutInflater.from(parent.context).inflate(R.layout.items_devic_list, parent, false),
//)
//{
//    private val nameText: TextView = itemView.findViewById(R.id.text_name)
//    private val numberText: TextView = itemView.findViewById(R.id.text_numer)
//    var device: Device? = null
//
//
//    fun bindTo(device: Device?) {
//        this.device = device
//        nameText.text = this.device?.name
//        numberText.text = this.device?.number
//    }
//
//}