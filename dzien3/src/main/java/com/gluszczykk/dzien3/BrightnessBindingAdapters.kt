package com.gluszczykk.dzien3

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

object BrightnessBindingAdapters {

    @JvmStatic
    @BindingAdapter("itemModel")
    fun setBrightnessImage(imageView: ImageView, brightness: Brightness){
        // TODO: 26/03/2021 Zmigruj
        //imageView.setImageResource(brightness.imageSrc)
    }
}