package com.bakisumqayit.trainapp

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object TrainApiClient {

    private val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()

    private val gson = Gson()

    suspend fun searchTrains(fromDate: String, toDate: String): List<TrainResult> =
        withContext(Dispatchers.IO) {
            try {
                // Mock data for demonstration
                // In production, this would fetch from the actual API
                getMockTrainResults(fromDate, toDate)
            } catch (e: Exception) {
                throw Exception("Axtarış zamanı xəta baş verdi: ${e.message}")
            }
        }

    private fun getMockTrainResults(fromDate: String, toDate: String): List<TrainResult> {
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
            ),
            TrainResult(
                id = "6",
                departureTime = "18:30",
                arrivalTime = "21:00",
                duration = "2s 30d",
                price = "5 AZN",
                trainNumber = "106",
                fromStation = "Bakı",
                toStation = "Sumqayıt"
            )
        )
    }

    // This method can be used to fetch from actual API in the future
    private suspend fun fetchFromApi(fromDate: String, toDate: String): List<TrainResult> =
        withContext(Dispatchers.IO) {
            try {
                val url = "https://www.baki-sumqayit.site/api/search?from=$fromDate&to=$toDate"
                val request = Request.Builder()
                    .url(url)
                    .build()

                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val body = response.body?.string() ?: return@withContext emptyList()
                    // Parse JSON response here
                    emptyList()
                } else {
                    throw Exception("API xətası: ${response.code}")
                }
            } catch (e: Exception) {
                throw Exception("Şəbəkə xətası: ${e.message}")
            }
        }
}
