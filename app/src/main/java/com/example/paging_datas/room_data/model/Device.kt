package com.example.paging_datas.room_data.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DiveseTable")

  class Device(
    @ColumnInfo(name = "dives_name")
    var name: String,
    @ColumnInfo(name = "device_number")
    var number: String,

    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}







