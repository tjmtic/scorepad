package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.Player

@Composable
fun TileCounterList(players: List<Player>, onCount: (player:Player, score: Int)->Unit) {

    LazyVerticalGrid(columns= GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        itemsIndexed(players) { index, item ->
                TileCounter(item, onCount)
        }
    }
}