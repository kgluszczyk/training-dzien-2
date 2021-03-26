package com.gluszczykk.dzien3

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

object Service {

    val httpClient = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(httpClient)
        .build()

    val brightnessService = retrofit.create(BrightnessService::class.java)

    interface BrightnessService {

        @GET("brightness")
        suspend fun getBrightnessesList() : List<Brightness>
    }
}

suspend fun getBrightnesses() = Service.brightnessService.getBrightnessesList()