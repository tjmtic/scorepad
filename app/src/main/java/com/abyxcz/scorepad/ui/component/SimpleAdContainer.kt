package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SimpleAdContainer(content: @Composable () -> Unit = { }) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        content()

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            SimpleAdView()
        }
    }

}