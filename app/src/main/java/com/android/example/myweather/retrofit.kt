package com.android.example.myweather

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private const val BASE_URL =
    "https://api.weatherapi.com/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WeatherAPIService {
    @GET("current.json?key=62178a04256a43f2b9f42703210711&q=Jakarta&aqi=yes")
    fun getCurrent():
            Call<Currentt>
}

object WeatherAPI {
    val retrofitService : WeatherAPIService by lazy {
        retrofit.create(WeatherAPIService::class.java) }
}