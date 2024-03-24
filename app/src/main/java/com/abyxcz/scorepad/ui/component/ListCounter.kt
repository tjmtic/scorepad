package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.abyxcz.scorepad.Tile

@Composable
fun TileListCounter(size: Int) {

    val board by remember { mutableStateOf(arrayOfNulls<Int>(size)) }

    LazyVerticalGrid(columns= GridCells.Fixed(3)) {
        itemsIndexed(board) { index, item ->
            TileCounter()
        }
    }
}