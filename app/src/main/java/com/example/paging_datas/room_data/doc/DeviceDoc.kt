package com.example.paging_datas.room_data.doc

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paging_datas.room_data.model.Device
import kotlinx.coroutines.flow.Flow


@Dao
interface DeviceDoc {
    @Insert(onConflict = 1)
      suspend  fun  insert(device: Device)

   @Query("SELECT * from DiveseTable")
     fun getAllDevice():PagingSource<Int,Device>

}