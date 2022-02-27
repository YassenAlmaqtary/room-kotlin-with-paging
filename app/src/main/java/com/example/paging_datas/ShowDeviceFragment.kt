package com.example.paging_datas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging_datas.databinding.FragmentShowDeviceBinding
import com.example.paging_datas.room_data.view.DeviceView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class ShowDeviceFragment : Fragment(R.layout.fragment_show_device) {
    lateinit var binding:FragmentShowDeviceBinding
    lateinit var myListAdabter:ListAdabter
    private val devicView: DeviceView by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentShowDeviceBinding.bind(view)
        myListAdabter=ListAdabter()
        binding.apply {
          recyler.apply {
              layoutManager= LinearLayoutManager(requireActivity().applicationContext)
              setHasFixedSize(true)
              adapter=myListAdabter
              lifecycleScope.launch{
                devicView.items.collect {
                  myListAdabter.submitData(it)
                }
              }
          }


        }




    }


}