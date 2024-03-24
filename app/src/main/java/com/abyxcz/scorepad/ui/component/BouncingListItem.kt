package com.abyxcz.scorepad.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abyxcz.scorepad.R

@Composable
fun BouncingListItem(
    item: String,
    isLoading: Boolean,
    imageUrl: Int?
) {
    val scale = remember { Animatable(1f) }

    LaunchedEffect(isLoading) {
        if (isLoading) {
            scale.animateTo(1.1f, animationSpec = keyframes {
                durationMillis = 300
                0.7f at 100
                1f at 200
                1.1f at 300
            })
        } else {
            scale.animateTo(1f)
        }
    }

    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .graphicsLayer(
                scaleX = scale.value,
                scaleY = scale.value
            )
    ) {
        Text(
            text = item,
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 18.sp)
        )

        // Image composable
        Image(
            painter = painterResource(id = imageUrl ?: R.mipmap.bg1), // Load image from resources
            contentDescription = null, // Provide content description
            contentScale = ContentScale.Fit, // Fit image within the space
            modifier = Modifier
                .size(48.dp) // Set size of the image
                .padding(8.dp) // Add padding
        )
    }
}
