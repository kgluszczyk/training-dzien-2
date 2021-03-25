package com.gluszczykk.dzien3

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gluszczykk.dzien3.databinding.ItemSelectorBinding

class BrightnessAdapter(private val items: List<Brightness>) : RecyclerView.Adapter<BrightnessViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrightnessViewHolder {
        val viewBinding = ItemSelectorBinding.inflate(LayoutInflater.from(parent.context))
        return BrightnessViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: BrightnessViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

class BrightnessViewHolder(private val viewBinding: ItemSelectorBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(item: Brightness) {
        viewBinding.root.findViewById<TextView>(R.id.label).apply {
            text = item.name
        }
    }
}