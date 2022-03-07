package com.example.paging_datas.room_data.view
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging_datas.room_data.model.Device
import com.example.paging_datas.room_data.rebostory.DeviceRebstory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class DeviceView
    @Inject
  constructor (private val rebstory: DeviceRebstory): ViewModel() {


//getallDevice
  //val allDevice:LiveData<List<Device>> =rebstory.allDevice.asLiveData()

 //insert
    fun insert(device: Device)=viewModelScope.launch{
     rebstory.insert(device)
 }

    val items=Pager(PagingConfig(
        pageSize =50,
    )){
     rebstory.allDevice
    }.flow

   // serach
    fun itemsSearchName(name:String): Flow<PagingData<Device>> = Pager(PagingConfig(
           pageSize =50,
       )){
           rebstory.allDeviceWitheName(name=name)
       }.flow

   //fillter
   fun filtterdeviceName(): Flow<PagingData<Device>> = Pager(PagingConfig(
       pageSize =50,
   )){
       rebstory.fillterDeviceName()
   }.flow

    fun fillterDeviceNumber(): Flow<PagingData<Device>> = Pager(PagingConfig(
       pageSize =50,
   )){
       rebstory.fillterDeviceNumber()
   }.flow






}



//class DeviceViewModelFactory(private val rebstory: DeviceRebstory):ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(DeviceView::class.java)){
//            @Suppress("UNCHECKED_CAST")
//            return  DeviceView(rebstory) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//
//    }
//
//}

