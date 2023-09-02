package com.hypheno.weatherapp.domain.repository

import com.hypheno.weatherapp.domain.util.Resource
import com.hypheno.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}