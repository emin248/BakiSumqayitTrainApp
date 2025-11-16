package com.bakisumqayit.trainapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bakisumqayit.trainapp.databinding.ItemTrainResultBinding

class TrainResultsAdapter(private var results: List<TrainResult>) :
    RecyclerView.Adapter<TrainResultsAdapter.TrainResultViewHolder>() {

    inner class TrainResultViewHolder(private val binding: ItemTrainResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: TrainResult) {
            binding.apply {
                // Main departure time
                departureTimeText.text = result.departureTime
                
                // Stations info
                stationsText.text = "${result.fromStation} → ${result.toStation}"
                
                // Price
                priceText.text = result.price
                
                // Train number
                trainNumberText.text = "Reys: ${result.trainNumber}"
                
                // Details row
                departureTimeText2.text = result.departureTime
                arrivalTimeText.text = result.arrivalTime
                durationText.text = result.duration
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainResultViewHolder {
        val binding = ItemTrainResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TrainResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainResultViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount(): Int = results.size

    fun updateResults(newResults: List<TrainResult>) {
        results = newResults
        notifyDataSetChanged()
    }
}
