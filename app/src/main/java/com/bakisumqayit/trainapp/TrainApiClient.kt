package com.bakisumqayit.trainapp

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

object TrainApiClient {

    private val client = OkHttpClient()
    private val gson = Gson()

    suspend fun searchTrains(fromDate: String, toDate: String): List<TrainResult> =
        withContext(Dispatchers.IO) {
            try {
                // Mock data for demonstration
                // In production, this would fetch from the actual API
                getMockTrainResults()
            } catch (e: Exception) {
                emptyList()
            }
        }

    private fun getMockTrainResults(): List<TrainResult> {
        return listOf(
            TrainResult(
                id = "1",
                departureTime = "06:00",
                arrivalTime = "08:30",
                duration = "2s 30d",
                price = "5 AZN",
                trainNumber = "101",
                fromStation = "Bakı",
                toStation = "Sumqayıt"
            ),
            TrainResult(
                id = "2",
                departureTime = "08:15",
                arrivalTime = "10:45",
                duration = "2s 30d",
                price = "5 AZN",
                trainNumber = "102",
                fromStation = "Bakı",
                toStation = "Sumqayıt"
            ),
            TrainResult(
                id = "3",
                departureTime = "10:30",
                arrivalTime = "13:00",
                duration = "2s 30d",
                price = "5 AZN",
                trainNumber = "103",
                fromStation = "Bakı",
                toStation = "Sumqayıt"
            ),
            TrainResult(
                id = "4",
                departureTime = "14:00",
                arrivalTime = "16:30",
                duration = "2s 30d",
                price = "5 AZN",
                trainNumber = "104",
                fromStation = "Bakı",
                toStation = "Sumqayıt"
            ),
            TrainResult(
                id = "5",
                departureTime = "16:45",
                arrivalTime = "19:15",
                duration = "2s 30d",
                price = "5 AZN",
                trainNumber = "105",
                fromStation = "Bakı",
                toStation = "Sumqayıt"
            )
        )
    }
}
