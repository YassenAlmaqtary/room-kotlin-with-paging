package com.example.paging_datas



import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.paging_datas.dailog.CancelDailolg
import com.example.paging_datas.databinding.FragmentFormDeviceBinding
import com.example.paging_datas.room_data.model.Device
import com.example.paging_datas.room_data.view.DeviceView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormDeviceFragment : Fragment(R.layout.fragment_form_device) {
    private lateinit var binding: FragmentFormDeviceBinding
    private val devicView: DeviceView by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFormDeviceBinding.bind(view)
        setupListeners()
        binding.apply {
            save.apply {
                setOnClickListener {
                    if (isValidate()) {
                        var name: String = binding.fromName.text.toString().trim()
                        var number: Int = binding.fromNumber.text.toString().trim().toInt()
                            devicView.insert(Device(name, number))
                         Snackbar.make(this,R.string.title_snake_sucses,Snackbar.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.showDeviceFragment)
                    }

                }
            }
          clear.apply {
              setOnClickListener {
                  CancelDailolg().show(childFragmentManager,CancelDailolg.TAG)

              }
          }

        }
    }

    private fun vidideName(): Boolean {

        if (binding.fromName.text.toString().trim().isEmpty()) {
            binding.laAddDevice.error = resources.getString(R.string.field_required)
            binding.fromName.requestFocus()
            return false
        } else {
            binding.laAddDevice.isErrorEnabled = false
        }
        return true
    }


    private fun vididenumber(): Boolean {

        if (binding.fromNumber.text.toString().trim().isEmpty()) {
            binding.laAddDevice.error =resources.getString(R.string.field_required)
            binding.fromNumber.requestFocus()
            return false

        } else if (binding.fromNumber.text.toString().length < 9) {
            binding.laAddNumber.error = "الرقم اقل من 9!"
            binding.fromNumber.requestFocus()
            return false

        } else {
            binding.laAddNumber.isErrorEnabled = false
            return true
        }

    }

    private fun isValidate(): Boolean = vidideName() && vididenumber()

    private fun setupListeners() {
        binding.fromName.addTextChangedListener(TextFieldValidation(binding.fromName))
        binding.fromNumber.addTextChangedListener(TextFieldValidation(binding.fromNumber))
    }

    inner class TextFieldValidation(private val view: View) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            when (view.id) {
                R.id.fromName -> {
                    vidideName()
                }
                R.id.fromNumber -> {
                    vididenumber()
                }
            }


        }

        override fun afterTextChanged(s: Editable?) {

        }
    }


}








