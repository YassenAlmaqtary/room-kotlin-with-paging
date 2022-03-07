package com.example.paging_datas.room_data.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "DiveseTable")
 data class Device(
    @ColumnInfo(name = "dives_name")
    var name: String?=null,
    @ColumnInfo(name = "device_number")
    var number: String?=null,

    ) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Int = 0
}







