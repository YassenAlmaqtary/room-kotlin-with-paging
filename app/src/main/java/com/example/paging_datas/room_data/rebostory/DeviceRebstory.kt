package com.example.paging_datas.room_data.rebostory

import androidx.paging.PagingSource
import com.example.paging_datas.room_data.doc.DeviceDoc
import com.example.paging_datas.room_data.model.Device
import javax.inject.Inject

class DeviceRebstory

@Inject
   constructor (private val deviceDoc: DeviceDoc) {
    val allDevice: PagingSource<Int, Device> = deviceDoc.getAllDevice()
    suspend fun insert(device: Device)=deviceDoc.insert(device)
}




