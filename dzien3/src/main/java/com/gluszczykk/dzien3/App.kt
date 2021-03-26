package com.gluszczykk.dzien3

import android.app.Application
import androidx.room.Room
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class App : Application() {

    companion object {
        lateinit var database: AppDatabase
        val moshi = Moshi.Builder().build()
        var adapter: JsonAdapter<List<Brightness>> = moshi.adapter(
            Types.newParameterizedType(
                MutableList::class.java,
                Brightness::class.java
            )
        )
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "config"
        ).build()
    }
}