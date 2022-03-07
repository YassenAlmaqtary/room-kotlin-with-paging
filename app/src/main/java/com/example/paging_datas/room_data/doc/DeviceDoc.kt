package com.example.paging_datas.room_data.doc

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paging_datas.room_data.model.Device



@Dao
interface DeviceDoc {
    @Insert(onConflict = 1)
      suspend  fun  insert(device: Device)

   @Query("SELECT * from DiveseTable")
     fun getAllDevice():PagingSource<Int,Device>


    @Query("SELECT * from DiveseTable WHERE dives_name like :name" )
    fun getAllDevice(name:String):PagingSource<Int,Device>


    @Query("SELECT id, dives_name From DiveseTable" )
    fun getFillterName():PagingSource<Int,Device>

    @Query("SELECT id, device_number From DiveseTable" )
    fun getFillterNumber():PagingSource<Int,Device>


}