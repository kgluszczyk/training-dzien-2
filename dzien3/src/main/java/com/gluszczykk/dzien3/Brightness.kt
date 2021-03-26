package com.gluszczykk.dzien3

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brightness(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val imageSrc: String,
    @field:Json(name = "opacity") val opacity: Double
) : Parcelable

@Entity
data class BrightnessConfig(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name="brightnessList") val brightnessList : List<Brightness>
)