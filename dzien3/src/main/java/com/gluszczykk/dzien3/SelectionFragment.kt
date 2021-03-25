package com.gluszczykk.dzien3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment(R.layout.fragment_selection) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BrightnessAdapter(getBrightnesses())
        val recyclerView = view.findViewById<RecyclerView>(R.id.brightness_list)
        recyclerView.adapter = adapter
    }
}