package com.example.vehiclehealthmonitor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehicleViewModel : ViewModel() {

    private val _engineHealth = MutableLiveData("Engine Health: OK")
    val engineHealth: LiveData<String> get() = _engineHealth

    private val _oilLevel = MutableLiveData("Oil Level: Full")
    val oilLevel: LiveData<String> get() = _oilLevel

    private val _tirePressure = MutableLiveData("Tire Pressure: Normal")
    val tirePressure: LiveData<String> get() = _tirePressure

    private val retrofit = RetrofitClient.getClient("")
    private val apiService = retrofit.create(RetrofitApiService::class.java)

    // Here you would add methods to update LiveData values based on sensor data

    fun fetchVehicleStatus() {
        viewModelScope.launch(Dispatchers.IO) {

            val response = apiService.getVehicleStatus().execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    _engineHealth.postValue(it.engineHealth)
                    _oilLevel.postValue(it.oilLevel)
                    _tirePressure.postValue(it.tirePressure)
                }
            }
        }
    }

    fun reportIssue(issue: IssueReport) {
        viewModelScope.launch(Dispatchers.IO) {
            apiService.reportIssue(issue).execute()
        }
    }
}
