package com.bakisumqayit.trainapp

import android.app.Activity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class AdManager(private val activity: Activity) {

    private var mInterstitialAd: InterstitialAd? = null
    private var onAdDismissedCallback: (() -> Unit)? = null
    private var onAdFailedCallback: (() -> Unit)? = null

    // Test Ad Unit ID - Replace with your actual Ad Unit ID for production
    private val AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            activity,
            AD_UNIT_ID,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                    showAd()
                }

                override fun onAdFailedToLoad(adError: com.google.android.gms.ads.LoadAdError) {
                    mInterstitialAd = null
                    // If ad fails to load, proceed with callback
                    onAdFailedCallback?.invoke()
                }
            }
        )
    }

    private fun showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.fullScreenContentCallback =
                object : com.google.android.gms.ads.FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        onAdDismissedCallback?.invoke()
                        mInterstitialAd = null
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        onAdFailedCallback?.invoke()
                        mInterstitialAd = null
                    }

                    override fun onAdShowedFullScreenContent() {
                        // Ad is shown
                    }
                }
            mInterstitialAd?.show(activity)
        } else {
            onAdFailedCallback?.invoke()
        }
    }

    fun setOnAdDismissedCallback(callback: () -> Unit) {
        onAdDismissedCallback = callback
    }

    fun setOnAdFailedCallback(callback: () -> Unit) {
        onAdFailedCallback = callback
    }

    fun showAd(onDismissed: () -> Unit, onFailed: () -> Unit) {
        onAdDismissedCallback = onDismissed
        onAdFailedCallback = onFailed
        loadInterstitialAd()
    }
}
