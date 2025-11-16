package com.bakisumqayit.trainapp

data class TrainResult(
    val id: String,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String,
    val price: String,
    val trainNumber: String,
    val fromStation: String,
    val toStation: String
)
