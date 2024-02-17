package com.example.mapasmvvmjuliangarrido.ui.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MapsViewModel : ViewModel() {
    private val _latitude = MutableLiveData<Double>().apply {
        value = 20.0
    }
    val latitude: LiveData<Double> = _latitude

    private val _longitude = MutableLiveData<Double>().apply {
        value = 8.0
    }
    val longitude: LiveData<Double> = _longitude

    fun setCoordinates(latitude: Double, longitude: Double) {
        _latitude.value = latitude
        _longitude.value = longitude
    }
}