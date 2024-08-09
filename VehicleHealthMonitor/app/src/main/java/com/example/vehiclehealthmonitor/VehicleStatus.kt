package com.example.vehiclehealthmonitor

data class VehicleStatus (
    val engineHealth: String,
    val oilLevel: String,
    val tirePressure: String
)
data class IssueReport(
    val issue: String
)