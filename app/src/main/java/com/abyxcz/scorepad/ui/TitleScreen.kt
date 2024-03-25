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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.Game
import com.abyxcz.scorepad.R
import com.abyxcz.scorepad.ui.component.BouncingListItem
import com.abyxcz.scorepad.ui.component.HighEndListItem
import com.abyxcz.scorepad.ui.component.SimpleAdContainer
import com.abyxcz.scorepad.ui.component.SimpleAdView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleScreen(onClick: () -> Unit, loadGame: (Game) -> Unit ) {
    Column {

        SimpleAdView()

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            itemsIndexed(
                arrayListOf(
                    Game.Games("TicTacToe", imageUrl = R.mipmap.bg1),
                    Game.Games("Dominos", R.mipmap.bg2)
                )
            ) { index, game ->


                Card(
                    onClick = { loadGame(game) },
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Column(
                        modifier = Modifier
                            /*.clickable {
                                println("CLICKED THE ${index}")
                                loadGame(game)
                            }*/
                            .background(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = RoundedCornerShape(20.dp),
                            )
                            .padding(22.dp),
                    ) {

                        HighEndListItem(imageUrl = game.imageUrl, title = game.name, specialDetail = game.name)
                    }
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