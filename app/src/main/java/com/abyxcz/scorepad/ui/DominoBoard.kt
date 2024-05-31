package com.abyxcz.scorepad.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.Player
import com.abyxcz.scorepad.R
import com.abyxcz.scorepad.ui.component.ControlButtons
import com.abyxcz.scorepad.ui.component.HighEndScoreboard

@Composable
fun DominoBoard(players: List<Player>, onClick: () -> Unit, onBack: () -> Unit, onCount: (player:Player, score: Int) -> Unit){


    var scores by rememberSaveable { mutableStateOf(List(players.size+1) { 0 } ) }
    var wins by rememberSaveable { mutableStateOf((List(players.size+1) { 0 } )) }

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
                "Reset Score",
                {
                    scores = List(players.size+1) { 0 }
                    wins = List(players.size+1) { 0 }
                },
                "Game Select",
                onBack,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            for (i in 0 until players.size) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clickable { scores = scores.toMutableList().apply { this[i] += 5 } }
                        .fillMaxSize()
                        .weight(1F)
                ) {
                    DominoScoreBoard(
                        title = players[i].name,
                        value = scores[i],
                        imageId = R.mipmap.oplus,
                        extraValue = wins[i].toString()
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable {
                        wins = wins.toMutableList().apply { this[this.lastIndex] += 1 }
                        scores = List(players.size+1) { 0 }
                    }
                    .fillMaxSize()
                    .weight(1F)

            ) {

                DominoScoreBoard(
                    title = "DRAW",
                    value = wins.last(),
                    imageId = R.mipmap.oplus,
                    extraValue = wins.last().toString()
                )
            }
        }
    }

    LaunchedEffect(scores){
        scores.mapIndexed{ index, it ->
            if(it >= 250){
                println("Player $index Wins!");
                scores = List(players.size+1) { 0 }
                wins = wins.toMutableList().apply { this[index] += 1 }
            }
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