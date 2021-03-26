package com.gluszczykk.dzien3

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class SelectionFragment : Fragment(R.layout.fragment_selection) {

    lateinit var viewModel: MainActivityViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

        val adapter = BrightnessAdapter {
            viewModel.action(it)
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.brightness_list)
        recyclerView.adapter = adapter
        lifecycleScope.launch {
            adapter.setData(getBrightnesses())
        }
    }
}