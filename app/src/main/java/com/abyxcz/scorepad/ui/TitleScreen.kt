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
import com.abyxcz.scorepad.Game
import com.abyxcz.scorepad.R
import com.abyxcz.scorepad.ui.component.BouncingListItem
import com.abyxcz.scorepad.ui.component.HighEndListItem
import com.abyxcz.scorepad.ui.component.HighEndTile
import com.abyxcz.scorepad.ui.component.SimpleAdContainer
import com.abyxcz.scorepad.ui.component.SimpleAdView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleScreen(onClick: () -> Unit, loadGame: (Game) -> Unit ) {
    Column {
        val gameList = arrayListOf(
            Game.Games("Tally", imageUrl = R.mipmap.tally),
            Game.Games("Dominos", R.mipmap.bg2),
            Game.Games("TicTacToe", R.mipmap.bg1),
            Game.Games("BasketBall", R.mipmap.basketball)

        )

        /*Row(modifier = Modifier.fillMaxHeight()){
            gameList.forEach {
                    Column(
                        modifier = Modifier
                            .clickable {
                                println("CLICKED THE ${it.name}")
                                loadGame(it)
                            }
                            .background(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = RoundedCornerShape(20.dp),
                            )
                            .padding(22.dp)
                            .weight(.5f)
                            .fillMaxHeight()
                    ) {
                        HighEndTile(imageUrl = it.imageUrl, title = it.name, specialDetail = it.name)
                    }
          }
        }*/

        LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = Modifier.fillMaxHeight()) {
            itemsIndexed(
                arrayListOf(
                    Game.Games("Tally", imageUrl = R.mipmap.tally),
                    Game.Games("TicTacToe", imageUrl = R.mipmap.xo),
                    Game.Games("Dominos", R.mipmap.bg2),
                    Game.Games("Basketball", R.mipmap.basketball)
                )
            ) { index, game ->


                Card(
                    onClick = { loadGame(game) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxHeight()
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
                            .padding(22.dp)
                            .fillMaxHeight(),
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
    MaterialTheme {
        TitleScreen({}, {})
    }
}