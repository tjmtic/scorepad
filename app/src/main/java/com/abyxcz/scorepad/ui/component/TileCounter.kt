package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.Player

@Composable
fun TileCounter(player: Player, onCount: (player:Player, score: Int)->Unit){

    var count by rememberSaveable { mutableStateOf(0) }

    Box(Modifier.clickable { count += 1; onCount(player, 1) }.fillMaxSize().background(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(20.dp),
    )) {
        Column(
            modifier = Modifier
                .padding(22.dp),
        ) {
            Text("${player.name} ${player.score} $count")
        }
    }
}