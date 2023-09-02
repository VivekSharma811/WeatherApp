package com.hypheno.weatherapp.data.repository

import com.hypheno.weatherapp.data.mappers.toWeatherInfo
import com.hypheno.weatherapp.data.remote.WeatherAPI
import com.hypheno.weatherapp.domain.repository.WeatherRepository
import com.hypheno.weatherapp.domain.util.Resource
import com.hypheno.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherAPI
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}