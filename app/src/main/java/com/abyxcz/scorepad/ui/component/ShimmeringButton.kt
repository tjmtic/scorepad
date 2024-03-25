package com.abyxcz.scorepad.ui.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShimmeringButton(
    onClick: () -> Unit,
    shimmerColor: Color,
    buttonContent: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "infinitetransition label")

    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ), label = "shimmerbutton label"
    )

    Box(
        modifier = Modifier
            .size(64.dp)
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Surface(
            shape = CircleShape,
            color = shimmerColor,
            modifier = Modifier
                .fillMaxSize()
                .rotate(rotationAngle)
        ) {}

        Surface(
            shape = CircleShape,
            color = Color.Cyan,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            buttonContent()
        }
    }
}