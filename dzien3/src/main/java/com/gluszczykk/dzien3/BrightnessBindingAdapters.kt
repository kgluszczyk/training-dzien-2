package com.gluszczykk.dzien3

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

object BrightnessBindingAdapters {

    @JvmStatic
    @BindingAdapter("itemModel")
    fun setBrightnessImage(imageView: ImageView, brightness: Brightness){
        imageView.setImageResource(brightness.imageSrc)
    }
}