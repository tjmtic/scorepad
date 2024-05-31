package com.abyxcz.scorepad.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.Player
import com.abyxcz.scorepad.R
import com.abyxcz.scorepad.ui.component.ControlButtons
import com.abyxcz.scorepad.ui.component.HighEndScoreboard
import com.abyxcz.scorepad.ui.component.HighEndTileCounterColumn
import com.abyxcz.scorepad.ui.component.NavigationButtons
import com.abyxcz.scorepad.ui.component.TileCounterList
import com.abyxcz.scorepad.ui.component.UserNameInputForm

@Composable
fun TicTacToeBoard(players: List<Player>, onClick: () -> Unit, onBack: () -> Unit, onCount: (player:Player, score: Int) -> Unit){
    var score1 by rememberSaveable { mutableStateOf(0)}
    var score2 by rememberSaveable { mutableStateOf(0)}
    var score3 by rememberSaveable { mutableStateOf(0)}

    Column {

        Box(
            modifier = Modifier
                .padding(vertical = 28.dp)

        ) {
            ControlButtons(
                "Reset Score", { score1 = 0; score2 = 0; score3 = 0 }, "Game Select", onBack, modifier = Modifier
                    .padding(vertical = 8.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                //.width(100.dp)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxWidth(1f)
                    .clickable { score1 += 1 }

            ) {

                TicTacToeScoreBoard(title = "Player 1", value = score1, imageId = R.mipmap.xplus)
                //TicTacToeScoreBoard(title = "Player 2", value = score1)
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxWidth(1f)
                    .clickable { score3 += 1 }

            ) {

                TicTacToeScoreBoard(title = "DRAW", value = score3, imageId = R.mipmap.infinity )
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxWidth(1f)
                    .clickable { score2 += 1 }

            ) {

                TicTacToeScoreBoard(title = "Player 2", value = score2, imageId = R.mipmap.oplus)
            }


            /*Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxSize()
                    //.fillMaxWidth(1f)
                    .clickable { score3 += 1 }

            ) {

                TicTacToeScoreBoard(title = "DRAW", value = score3)
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxSize()
                    //.fillMaxWidth(1f)
                    .clickable { score2 += 1 }

            ) {

                TicTacToeScoreBoard(title = "Player 2", value = score2)
            }*/
        }

    }
}

@Composable
fun TicTacToeScoreBoard(title: String, value: Int, imageId: Int){

    HighEndScoreboard(title = title, value = value, logo = imageId,
        modifier = Modifier.width(100.dp).size(100.dp))

}


@Preview
@Composable
fun TicTacToeBoardPreview(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null), Player("3", 3, Color(0xFF00FF00), null))

    TicTacToeBoard(players = list, onClick = {}, onBack = {}, onCount = { _ , _ -> {} })
}