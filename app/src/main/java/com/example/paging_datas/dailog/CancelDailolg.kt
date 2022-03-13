package com.example.paging_datas.dailog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.paging_datas.R
import com.google.android.material.textfield.TextInputEditText

class CancelDailolg: DialogFragment(R.layout.fragment_form_device) {

    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog=AlertDialog.Builder(requireContext()).setMessage("تمكين الالغاء")
        .setPositiveButton("تائكيد"){ _,_ ->
            findNavController().popBackStack()
        }
        .setNegativeButton("الغاء"){_,_ ->
        }
        .create()


}