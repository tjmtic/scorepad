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
import androidx.compose.runtime.LaunchedEffect
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
import com.abyxcz.scorepad.TicTacToeTile
import com.abyxcz.scorepad.Tile
import com.abyxcz.scorepad.ui.component.ControlButtons
import com.abyxcz.scorepad.ui.component.HighEndScoreboard
import com.abyxcz.scorepad.ui.component.HighEndTileCounterColumn
import com.abyxcz.scorepad.ui.component.NavigationButtons
import com.abyxcz.scorepad.ui.component.TileCounterList
import com.abyxcz.scorepad.ui.component.UserNameInputForm

@Composable
fun DominoBoard(players: List<Player>, onClick: () -> Unit, onBack: () -> Unit, onCount: (player:Player, score: Int) -> Unit){
    var score1 by rememberSaveable { mutableStateOf(0)}
    var score2 by rememberSaveable { mutableStateOf(0)}
    var score3 by rememberSaveable { mutableStateOf(0)}
    var score4 by rememberSaveable { mutableStateOf(0)}

    var win1 by rememberSaveable { mutableStateOf(0)}
    var win2 by rememberSaveable { mutableStateOf(0)}
    var win3 by rememberSaveable { mutableStateOf(0)}
    var win4 by rememberSaveable { mutableStateOf(0)}
    var win5 by rememberSaveable { mutableStateOf(0)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .padding(vertical = 28.dp)

        ) {
            ControlButtons(
                "Reset Score", { score1 = 0; score2 = 0; score3 = 0; score4 = 0; win1 = 0; win2 = 0; win3 = 0; win4 = 0;}, "Game Select", onBack, modifier = Modifier
                    .padding(vertical = 8.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
               // .fillMaxSize()
                //.width(100.dp)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxWidth(1f)
                    .clickable { score1 += 5 }
                    .fillMaxSize()
                    .weight(1F)

            ) {

                DominoScoreBoard(title = "Player 1", value = score1, imageId = R.mipmap.xplus, extraValue = win1.toString())
                //TicTacToeScoreBoard(title = "Player 2", value = score1)
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxWidth(1f)
                    .clickable { score2 += 5 }
                    .fillMaxSize()
                    .weight(1F)

            ) {

                DominoScoreBoard(title = "Player 2", value = score2, imageId = R.mipmap.infinity, extraValue = win2.toString() )
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxWidth(1f)
                    .clickable { score3 += 5 }
                    .fillMaxSize()
                    .weight(1F)

            ) {

                DominoScoreBoard(title = "Player 3", value = score3, imageId = R.mipmap.oplus, extraValue = win3.toString())
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxWidth(1f)
                    .clickable { score4 += 5 }
                    .fillMaxSize()
                    .weight(1F)

            ) {

                DominoScoreBoard(title = "Player 4", value = score4, imageId = R.mipmap.oplus, extraValue = win4.toString())
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    //.fillMaxWidth(1f)
                    .clickable { win5+=1; println("DRAW!"); score1 = 0; score2 = 0; score3 = 0; score4 = 0; }
                    .fillMaxSize()
                    .weight(1F)

            ) {

                DominoScoreBoard(title = "DRAW", value = win5, imageId = R.mipmap.oplus, extraValue = win5.toString())
            }
        }

    }

    LaunchedEffect(score1, score2, score3, score4){
        when {
            score1 >= 250 -> { println("Player1 Wins!"); win1 += 1; score1 = 0; score2 = 0; score3 = 0; score4 = 0; }
            score2 >= 250 -> { println("Player2 Wins!"); win2 += 1; score1 = 0; score2 = 0; score3 = 0; score4 = 0;}
            score3 >= 250 -> { println("Player3 Wins!"); win3 += 1; score1 = 0; score2 = 0; score3 = 0; score4 = 0;}
            score4 >= 250 -> { println("Player4 Wins!"); win4 += 1; score1 = 0; score2 = 0; score3 = 0; score4 = 0;}
        }
    }
}

@Composable
fun DominoScoreBoard(title: String, value: Int, imageId: Int, extraValue: String){

    HighEndScoreboard(title = "$title -- Wins: $extraValue", value = value, logo = imageId,
        modifier = Modifier.width(100.dp).size(100.dp))

}


@Preview
@Composable
fun DominoBoardPreview(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null), Player("3", 3, Color(0xFF00FF00), null))

    DominoBoard(players = list, onClick = {}, onBack = {}, onCount = { _ , _ -> {} })
}