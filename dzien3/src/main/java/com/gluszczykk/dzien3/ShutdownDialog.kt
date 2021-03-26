package com.gluszczykk.dzien3

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.gluszczykk.dzien3.databinding.FormBinding

class ShutdownDialog : DialogFragment() {

   /* override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Zamknij aplikacje")
            .setMessage("Jesteś pewien?")
            .setView(R.layout.form)
            .setPositiveButton("Tak") { _, _ -> requireActivity().finish() }
            .setNeutralButton("Nie wiem") { _, _ -> }
            .setNegativeButton("Nie!") { dialog, _ -> dialog.dismiss() }
            .create()
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FormBinding.inflate(inflater)
        //Alternatywnie
        // val view = inflater.inflate(R.layout.form,container)
        binding.submit.setOnClickListener {
            dialog?.dismiss()
        }
        return binding.root
    }
}