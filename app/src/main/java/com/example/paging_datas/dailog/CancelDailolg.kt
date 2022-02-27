package com.example.paging_datas.dailog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText

class CancelDailolg( nameinputClear: TextInputEditText, numberinputClear: TextInputEditText): DialogFragment() {
    private lateinit var nameinputClear:TextInputEditText
    private lateinit var numberinputClear: TextInputEditText
    init {
        this.nameinputClear= nameinputClear
        this.numberinputClear=numberinputClear
    }
    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog=AlertDialog.Builder(requireContext()).setMessage("تمكين الالغاء")
          .setPositiveButton("الغاء"){ _,_ ->
              this.nameinputClear.text?.clear()
              this.numberinputClear.text?.clear()
          }
          .create()


}