package com.example.paging_datas.room_data.serves

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
 object  DataRoomInstance {

    @Singleton
    @Provides
    fun getInstance(@ApplicationContext context: Context,): DeviceRoomDb
        = Room.databaseBuilder(
        context.applicationContext,
          DeviceRoomDb::class.java,
        "device-database"
        )
          //  .addCallback(DeviceDatabaseCallback(scope))
            .build()

    @Singleton
    @Provides
    fun providerToDeviceDoc (db: DeviceRoomDb)=db.deviceDoc()

}