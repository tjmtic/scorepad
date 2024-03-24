package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


@Composable
fun SimpleAdView(adUnitId : String = "ca-app-pub-3940256099942544/6300978111") { //Google Test Id
    Box (modifier = Modifier.fillMaxWidth()) {
        //Google AdMob
        AndroidView(
            modifier = Modifier.align(Alignment.Center), // Occupy the max size in the Compose UI tree
            factory = { context ->
                AdView(context).apply {
                    this.setAdSize(AdSize.BANNER)

                    //Google Test Ad ID
                    this.adUnitId = adUnitId

                    val adRequest = AdRequest.Builder().build()
                    this.loadAd(adRequest)
                }
            }
        )
    }
}