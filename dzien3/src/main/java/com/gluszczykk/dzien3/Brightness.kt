package com.gluszczykk.dzien3

import androidx.annotation.DrawableRes
import com.squareup.moshi.Json

data class Brightness(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val imageSrc: String,
    @field:Json(name = "opacity") val opacity: Double
)