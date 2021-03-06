package com.gluszczykk.dzien3

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.gluszczykk.dzien3.App.Companion.adapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@Dao
interface BrightnessConfigDao {

    @Query("SELECT * FROM brightnessconfig ORDER BY brightnessconfig.id DESC LIMIT 1")
    fun get(): LiveData<BrightnessConfig>

    @Insert
    fun insert(brightnessConfig: BrightnessConfig)
}

@TypeConverters(Converters::class)
@Database(entities = [BrightnessConfig::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun configDao(): BrightnessConfigDao
}

class Converters {
    @TypeConverter
    fun listToJson(list: List<Brightness>?) = adapter.toJson(list)

    @TypeConverter
    fun jsonToList(value: String) = adapter.fromJson(value)
}