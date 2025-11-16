package com.bakisumqayit.trainapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var routeSpinner: Spinner
    private lateinit var fromDateSpinner: Spinner
    private lateinit var toDateSpinner: Spinner
    private lateinit var dayOfWeekSpinner: Spinner
    private lateinit var searchButton: Button
    private lateinit var swapButton: ImageButton
    private lateinit var resultsRecyclerView: RecyclerView
    private lateinit var resultsAdapter: TrainResultsAdapter

    private var mInterstitialAd: InterstitialAd? = null
    private val AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712" // Test Ad Unit ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Mobile Ads SDK
        MobileAds.initialize(this)

        // Initialize UI components
        initializeUI()

        // Set up search button click listener
        searchButton.setOnClickListener {
            performSearchWithAd()
        }

        // Set up swap button click listener
        swapButton.setOnClickListener {
            swapStations()
        }
    }

    private fun initializeUI() {
        routeSpinner = findViewById(R.id.routeSpinner)
        fromDateSpinner = findViewById(R.id.fromDateSpinner)
        toDateSpinner = findViewById(R.id.toDateSpinner)
        dayOfWeekSpinner = findViewById(R.id.dayOfWeekSpinner)
        searchButton = findViewById(R.id.searchButton)
        swapButton = findViewById(R.id.swapButton)
        resultsRecyclerView = findViewById(R.id.resultsRecyclerView)

        // Set up spinners with data
        setupRouteSpinner()
        setupDateSpinners()
        setupDayOfWeekSpinner()

        // Set up RecyclerView
        resultsAdapter = TrainResultsAdapter(emptyList())
        resultsRecyclerView.layoutManager = LinearLayoutManager(this)
        resultsRecyclerView.adapter = resultsAdapter
    }

    private fun setupRouteSpinner() {
        val routes = arrayOf("Bakı-Pirşağı-Sumqayıt")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, routes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        routeSpinner.adapter = adapter
    }

    private fun setupDateSpinners() {
        val dates = arrayOf(
            "Tarix seçin...",
            "11.11.2025",
            "12.11.2025",
            "13.11.2025",
            "14.11.2025",
            "15.11.2025",
            "16.11.2025",
            "17.11.2025",
            "18.11.2025",
            "19.11.2025",
            "20.11.2025"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dates)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fromDateSpinner.adapter = adapter
        toDateSpinner.adapter = adapter
    }

    private fun setupDayOfWeekSpinner() {
        val days = arrayOf("Bazar")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dayOfWeekSpinner.adapter = adapter
    }

    private fun swapStations() {
        // In this case, route is fixed, but we can show a message
        Toast.makeText(this, "Marşrut sabitdir", Toast.LENGTH_SHORT).show()
    }

    private fun performSearchWithAd() {
        val fromDate = fromDateSpinner.selectedItem.toString()
        val toDate = toDateSpinner.selectedItem.toString()

        if (fromDate == "Tarix seçin..." || toDate == "Tarix seçin...") {
            Toast.makeText(this, "Başlanğıc və son stansiyaları seçin \"Axtar\" düyməsini basın.", Toast.LENGTH_SHORT).show()
            return
        }

        showInterstitialAd()
    }

    private fun showInterstitialAd() {
        loadInterstitialAd()
    }

    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            AD_UNIT_ID,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                    showAd()
                }

                override fun onAdFailedToLoad(adError: com.google.android.gms.ads.LoadAdError) {
                    mInterstitialAd = null
                    // If ad fails to load, proceed with search anyway
                    performSearch()
                }
            }
        )
    }

    private fun showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.fullScreenContentCallback =
                object : com.google.android.gms.ads.FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        performSearch()
                        mInterstitialAd = null
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        performSearch()
                        mInterstitialAd = null
                    }

                    override fun onAdShowedFullScreenContent() {
                        // Ad is shown
                    }
                }
            mInterstitialAd?.show(this@MainActivity)
        } else {
            performSearch()
        }
    }

    private fun performSearch() {
        val fromDate = fromDateSpinner.selectedItem.toString()
        val toDate = toDateSpinner.selectedItem.toString()

        lifecycleScope.launch {
            try {
                val results = TrainApiClient.searchTrains(fromDate, toDate)
                resultsAdapter.updateResults(results)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Xəta: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
