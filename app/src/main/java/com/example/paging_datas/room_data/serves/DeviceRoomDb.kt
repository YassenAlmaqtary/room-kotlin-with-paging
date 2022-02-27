package com.example.paging_datas.room_data.serves

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging_datas.room_data.doc.DeviceDoc
import com.example.paging_datas.room_data.model.Device


@Database(entities = arrayOf(Device::class),version = 1,exportSchema = false)
abstract class DeviceRoomDb: RoomDatabase() {
    abstract fun deviceDoc(): DeviceDoc

//private  class  DeviceDatabaseCallback(
//    private val scope: CoroutineScope
//):RoomDatabase.Callback(){
//
//    override fun onCreate(db: SupportSQLiteDatabase) {
//        super.onCreate(db)
//        INSTANCE?.let {
//            deviceRoomDb ->scope.launch {
//               var devicdDoc=deviceRoomDb.deviceDoc()
//                var device: Device = Device("udhhw","123456")
//        }
//        }
//    }
//}


//  companion object  {
//
//      @Volatile
//   private var INSTANCE: DeviceRoomDb?=null
//
//
//    @Synchronized
//    fun getInstance(context:Context,scope: CoroutineScope): DeviceRoomDb {
//        return INSTANCE ?:Room.databaseBuilder(
//        context.applicationContext,
//          DeviceRoomDb::class.java,
//        "device-database"
//        )
//          //  .addCallback(DeviceDatabaseCallback(scope))
//            .build()
//    }
//
//  }



}