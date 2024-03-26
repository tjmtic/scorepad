package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NavigationButtons(
    onNextClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        ArtisticButton(
            onClick = onBackClicked,
            gradientColors = listOf(Color(0xFFEF5350), Color(0xFFB71C1C)),
            buttonText = "Back",
            modifier = Modifier.weight(1f)
        )

        ArtisticButton(
            onClick = onNextClicked,
            gradientColors = listOf(Color(0xFF66BB6A), Color(0xFF1B5E20)),
            buttonText = "Next",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun NavigationButtonsPreview() {
    MaterialTheme {
        NavigationButtons(
            onNextClicked = {},
            onBackClicked = {}
        )
    }
}
