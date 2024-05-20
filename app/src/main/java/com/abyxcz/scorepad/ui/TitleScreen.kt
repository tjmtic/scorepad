package com.abyxcz.scorepad.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.R
import com.abyxcz.scorepad.data.Game
import com.abyxcz.scorepad.data.displayName
import com.abyxcz.scorepad.data.getProperties
import com.abyxcz.scorepad.ui.component.BouncingListItem
import com.abyxcz.scorepad.ui.component.HighEndListItem
import com.abyxcz.scorepad.ui.component.HighEndTile
import com.abyxcz.scorepad.ui.component.SimpleAdContainer
import com.abyxcz.scorepad.ui.component.SimpleAdView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleScreen(onClick: () -> Unit, loadGame: (Game) -> Unit ) {
    Column {

        LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = Modifier.fillMaxHeight()) {
            itemsIndexed(
                arrayListOf(
                    Game.Tally("Tally Ho!"),
                    Game.Dominos(4),
                    Game.TicTacToe(2),
                    Game.Basketball(16, "hoopre")
                )
            ) { index, game ->


                Card(
                    onClick = { loadGame(game) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxHeight()
                ) {

                    Column(
                        modifier = Modifier

                            .background(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = RoundedCornerShape(20.dp),
                            )
                            .padding(22.dp)
                            .fillMaxHeight(),
                    ) {

                        HighEndListItem(imageUrl = game.getProperties().image, title = game.getProperties().name, specialDetail = game.displayName)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTitleScreen(){
    MaterialTheme {
        TitleScreen({}, {})
    }
}