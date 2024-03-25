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
        ShimmeringButton(
            onClick = onBackClicked,
            shimmerColor = Color(0xFF42A5F5),
            buttonContent = { Text(text = "Back") }
        )

        ShimmeringButton(
            onClick = onNextClicked,
            shimmerColor = Color(0xFF42A5F5),
            buttonContent = { Text(text = "Next") }
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
