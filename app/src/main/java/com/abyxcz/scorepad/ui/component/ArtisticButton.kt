package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ArtisticButton(
    onClick: () -> Unit,
    gradientColors: List<Color>,
    buttonText: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .clickable(onClick = onClick)
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(
                    brush = Brush.horizontalGradient(gradientColors),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
            )
        }
    }
}

@Preview
@Composable
fun previewArtisticButton(){
    MaterialTheme {
        ArtisticButton(
            onClick = { /*TODO*/ },
            gradientColors = listOf(Color(0xFFFFFF00), Color(0xFFB71C1C)),
            buttonText = "Artistic"
        )
    }
}