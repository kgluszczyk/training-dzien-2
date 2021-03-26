package com.gluszczykk.dzien3

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ShutdownDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Zamknij aplikacje")
            .setMessage("Jesteś pewien?")
            .setView(R.layout.form)
            .setPositiveButton("Tak") { _, _ -> requireActivity().finish() }
            .setNeutralButton("Nie wiem") { _, _ -> }
            .setNegativeButton("Nie!") { dialog, _ -> dialog.dismiss() }
            .create()
    }
}