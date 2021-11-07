package com.android.example.myweather

data class Currentt(
    val current: Current,
)

data class Current(
    val wind_kph:Double,
    val pressure_mb: Double,
    val precip_mm: Double,
    val humidity : Int,
    val cloud : Int,
    val gust_kph : Double,
    val temp_c : Double,
    val last_updated :String,
    val condition: Condition
)
data class Condition(
    val text: String
)
