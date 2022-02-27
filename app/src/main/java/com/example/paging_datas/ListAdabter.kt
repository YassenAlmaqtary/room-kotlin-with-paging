package com.example.paging_datas

import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging_datas.room_data.model.Device

class ListAdabter():PagingDataAdapter<Device,ListViewHolder>(DIFF_CALLBACK){
    companion object{
       private val DIFF_CALLBACK=object:DiffUtil.ItemCallback<Device>(){

           override fun areItemsTheSame(oldItem: Device, newItem: Device): Boolean = oldItem.id==newItem.id

           override fun areContentsTheSame(oldItem: Device, newItem: Device):Boolean =oldItem.equals(newItem)

       }
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int){
          val device: Device?=getItem(position)
        holder.bindTo(device)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ListViewHolder{
        return ListViewHolder(parent)

    }

}