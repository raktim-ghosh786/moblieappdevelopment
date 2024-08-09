package com.example.vehiclehealthmonitor

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApiService {

    @GET("vehicle/status")
    fun getVehicleStatus(): Call<VehicleStatus>

    @POST("vehicle/report")
    fun reportIssue(@Body issueReport: IssueReport): Call<Void>

}