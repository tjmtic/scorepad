package com.abyxcz.scorepad.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.TicTacToeTile
import com.abyxcz.scorepad.Tile
import com.abyxcz.scorepad.ui.component.TileCounterList

@Composable
fun GameScreen(board: List<TicTacToeTile>, onClick: (Int) -> Unit){

    LazyVerticalGrid(columns= GridCells.Fixed(3)) {
        itemsIndexed(board) { index, item ->
            Tile(item) { onClick(index) }
        }
    }

    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxSize()

    ) {

        //TODO: Num Players
        TileCounterList(size = 2)
    }
}


@Preview
@Composable
fun GameScreenPreview(){
    GameScreen(board = mutableListOf<TicTacToeTile>().apply{ repeat(9){ this.add(
        TicTacToeTile()
    )}}, onClick = {})
}