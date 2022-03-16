package com.example.paging_datas

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging_datas.databinding.ItemsDevicListBinding
import com.example.paging_datas.room_data.model.Device

class ListAdabter(): PagingDataAdapter<Device,ListAdabter.ListViewHolder>(DIFF_CALLBACK) {

    lateinit var onClikLisener: OnClikLisener
    companion object{
        private val DIFF_CALLBACK=object:DiffUtil.ItemCallback<Device>(){

            override fun areItemsTheSame(oldItem: Device, newItem: Device): Boolean {
                Log.d("old","olditem")
                return oldItem.id==newItem.id

            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Device, newItem: Device):Boolean = oldItem == newItem
        }
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int){
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ListViewHolder = ListViewHolder.from(parent,onClikLisener)

    class ListViewHolder(val binding: ItemsDevicListBinding,var lisner:OnClikLisener):RecyclerView.ViewHolder(binding.root) {

        fun bindTo(device: Device?) {
            if (device != null)
            {
                binding.apply {
                    deviceItem = device
                    imageClear.setOnClickListener {
                       lisner.onIemClick(device,binding.imageClear)
                    }
                }
            }
        }
        companion object {
            fun from(parent: ViewGroup,lisner: OnClikLisener): ListViewHolder {
                val context = parent.context
                val layoutInflater = LayoutInflater.from(context)
                val binding = ItemsDevicListBinding.inflate(layoutInflater, parent, false)
                return ListViewHolder(binding,lisner)
            }
        }

    }

    fun  setOnClicLisner( lisner:OnClikLisener):Unit{
        this.onClikLisener=lisner
    }

    interface  OnClikLisener{
        fun onIemClick(device: Device?, image:ImageView)

    }


}

