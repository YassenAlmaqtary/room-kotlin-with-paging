package com.example.paging_datas.dailog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class CancelDailolg: DialogFragment() {

    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog=AlertDialog.Builder(requireContext()).setMessage("تمكين الالغاء")
        .setPositiveButton("تائكيد"){ _,_ ->
            findNavController().popBackStack()
        }
        .setNegativeButton("الغاء"){_,_ ->
        }
        .create()


}