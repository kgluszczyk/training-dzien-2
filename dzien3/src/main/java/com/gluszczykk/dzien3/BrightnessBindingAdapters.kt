package com.gluszczykk.dzien3

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BrightnessBindingAdapters {

    @JvmStatic
    @BindingAdapter("itemModel")
    fun setBrightnessImage(imageView: ImageView, brightness: Brightness){
        Glide.with(imageView)
            .load(brightness.imageSrc)
            .centerCrop()
            .into(imageView)
    }
}