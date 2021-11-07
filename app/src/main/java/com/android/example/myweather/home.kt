package com.android.example.myweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val forecastbutton= root.findViewById<Button>(R.id.forecastbutton)
        forecastbutton.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_blankFragment2)
        }
        val windspeed = root.findViewById<TextView>(R.id.windspeed)
        val pressure = root.findViewById<TextView>(R.id.pressure)
        val precipitation = root.findViewById<TextView>(R.id.precipitation)
        val humidity = root.findViewById<TextView>(R.id.humidity)
        val cloud = root.findViewById<TextView>(R.id.cloud)
        val windgust= root.findViewById<TextView>(R.id.windgust)
        val temp= root.findViewById<TextView>(R.id.temperature)
        val condition=root.findViewById<TextView>(R.id.condition)
        val last= root.findViewById<TextView>(R.id.last)
        val res = WeatherAPI.retrofitService.getCurrent()
        res.enqueue(object: Callback<Currentt> {
            override fun onResponse(call: Call<Currentt>, response: Response<Currentt>) {

                val body = response.body()
                val wind_kph = body?.current?.wind_kph
                val pressure_mb = body?.current?.pressure_mb
                val precip_mm = body?.current?.precip_mm
                val humidit = body?.current?.humidity
                val croud = body?.current?.cloud
                val gust_kph= body?.current?.gust_kph
                val temp_c = body?.current?.temp_c
                val conditi = body?.current?.condition?.text
                val last_update= body?.current?.last_updated
                windspeed.text = "wind Speed: $wind_kph"
                pressure.text = "Pressure : $pressure_mb"
                precipitation.text = "precipitation : $precip_mm"
                humidity.text = "humidity: $humidit"
                cloud.text = "cloud: $croud"
                windgust.text = "windgust : $gust_kph"
                temp.text = "$temp_c"
                condition.text = "$conditi"
                last.text = "$last_update"




            }
            override fun onFailure(call: Call<Currentt>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return root
    }

}