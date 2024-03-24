package com.abyxcz.scorepad.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.Game
import com.abyxcz.scorepad.ui.component.BouncingListItem
import com.abyxcz.scorepad.ui.component.SimpleAdContainer
import com.abyxcz.scorepad.ui.component.SimpleAdView

@Composable
fun TitleScreen(onClick: () -> Unit, loadGame: (Game) -> Unit ) {
    Column {

        SimpleAdView()

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            itemsIndexed(
                arrayListOf(
                    Game.Games("TicTacToe"),
                    Game.Games("Dominos")
                )
            ) { index, game ->
                Column(
                    modifier = Modifier
                        .clickable {
                            println("CLICKED THE ${index}")
                            loadGame(game)
                        }
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(20.dp),
                        )
                        .padding(22.dp),
                ) {
                    BouncingListItem(item = game.name, isLoading = true, imageUrl = null)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTitleScreen(){
    TitleScreen({}, {})
}