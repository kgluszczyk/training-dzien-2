package com.gluszczykk.dzien3

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gluszczykk.dzien3.databinding.ItemSelectorBinding

class BrightnessAdapter(private var items: List<Brightness> = listOf(), private val onBrightnessClickListener: OnBrightnessClickListener) : RecyclerView.Adapter<BrightnessViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrightnessViewHolder {
        val viewBinding = ItemSelectorBinding.inflate(LayoutInflater.from(parent.context))
        return BrightnessViewHolder(viewBinding, onBrightnessClickListener)
    }

    override fun onBindViewHolder(holder: BrightnessViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun setData(items: List<Brightness>){
        this.items = items
        notifyDataSetChanged()
    }
}

typealias OnBrightnessClickListener = (Brightness) -> Unit

class BrightnessViewHolder(private val viewBinding: ItemSelectorBinding, private val onBrightnessClickListener: OnBrightnessClickListener) : RecyclerView.ViewHolder(viewBinding.root) {
    fun bind(item: Brightness) {
        viewBinding.itemModel = item
        viewBinding.root.setOnClickListener {
            viewBinding.karta.setCardBackgroundColor(viewBinding.root.context.resources.getColor(android.R.color.darker_gray))
            onBrightnessClickListener(item)
        }
    }
}