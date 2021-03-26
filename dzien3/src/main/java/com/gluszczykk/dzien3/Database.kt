package com.gluszczykk.dzien3

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@Dao
interface BrightnessConfigDao {

    @Query("SELECT * FROM brightnessconfig ORDER BY brightnessconfig.id DESC LIMIT 1")
    fun get(): BrightnessConfig

    @Insert
    fun insert(brightnessConfig: BrightnessConfig)
}

@TypeConverters(Converters::class)
@Database(entities = [BrightnessConfig::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun configDao(): BrightnessConfigDao
}

object Converters {

    val moshi = Moshi.Builder().build()
    var adapter: JsonAdapter<List<Brightness>> = moshi.adapter(
        Types.newParameterizedType(
            MutableList::class.java,
            Brightness::class.java
        )
    )

    @TypeConverter
    fun listToJson(list: List<Brightness>?) = adapter.toJson(list)

    @TypeConverter
    fun jsonToList(value: String) = adapter.fromJson(value)
}