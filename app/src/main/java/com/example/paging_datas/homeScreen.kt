package com.example.paging_datas

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.paging_datas.databinding.FragmentFormDeviceBinding
import com.example.paging_datas.databinding.FragmentHomeScreenBinding
import kotlinx.android.synthetic.main.fragment_home_screen.*

class HomeScreen : Fragment(R.layout.fragment_home_screen) {
    private lateinit var binding: FragmentHomeScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)
        binding.apply {
            addDevice.setOnClickListener {
            findNavController().navigate(R.id.homeScreen_to_formDeviceFragment)

            }
            showDevice.setOnClickListener {

                 findNavController().navigate(R.id.action_homeScreen_to_showDeviceFragment)

            }

        }
    }
}