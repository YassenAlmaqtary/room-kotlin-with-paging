package com.example.paging_datas

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paging_datas.databinding.FragmentShowDeviceBinding
import com.example.paging_datas.room_data.model.Device
import com.example.paging_datas.room_data.view.DeviceView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShowDeviceFragment() : Fragment(R.layout.fragment_show_device),
    SearchView.OnQueryTextListener, AdapterView.OnItemSelectedListener {
    lateinit var binding: FragmentShowDeviceBinding
    var oury: String? = null
    lateinit var myListAdabter: ListAdabter
    private val devicView: DeviceView by viewModels()
    private lateinit var array: Array<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        array = resources.getStringArray(R.array.filter_device)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.title =
            resources.getString(R.string.showDevice)
        binding = FragmentShowDeviceBinding.bind(view)
        myListAdabter = ListAdabter()
        binding.apply {

            recyler.apply {
                layoutManager = LinearLayoutManager(requireActivity().applicationContext)
                setHasFixedSize(true)
                myListAdabter.setOnClicLisner(object:ListAdabter.OnClikLisener{
                    override fun onIemClick(device: Device?, image: ImageView) {
                      Toast.makeText(activity,device!!.name,Toast.LENGTH_LONG).show()

                    }
                })
                adapter = myListAdabter
            }
            //spinner
            ArrayAdapter.createFromResource(
                this@ShowDeviceFragment.requireContext().applicationContext, R.array.filter_device,
                android.R.layout.simple_spinner_item
            ).also { adabter ->
                adabter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                Spinner.adapter = adabter
            }

            Spinner.onItemSelectedListener = this@ShowDeviceFragment

        }
        getAllDevice()


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_minue, menu)
        val search = menu?.findItem(R.id.manue_search)
        val searchView = search?.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)

    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            serchName(query as String)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            serchName(newText)
        }
        return true

    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity?)!!.supportActionBar?.title =
            resources.getString(R.string.title_home)
        findNavController().popBackStack(R.id.formDeviceFragment,true)
    }

    fun getAllDevice() {
        lifecycleScope.launch {
            devicView.items.collect {
                myListAdabter.submitData(it)
            }
        }

    }

    fun serchName(qury: String) {
        val serachQury = "%$qury%"
        lifecycleScope.launch {
            devicView.itemsSearchName(serachQury).collect {
                myListAdabter.submitData(it)
            }
        }

    }

    fun filtterDeviceName() {
        lifecycleScope.launch {
            devicView.filtterdeviceName().collect {
                myListAdabter.submitData(it)
            }
        }

    }

    fun fillterDeviceNumber() {
        lifecycleScope.launch {
            devicView.fillterDeviceNumber().collect {
                myListAdabter.submitData(it)
            }
        }

    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> getAllDevice()
            1 -> filtterDeviceName()
            2 -> fillterDeviceNumber()
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}



