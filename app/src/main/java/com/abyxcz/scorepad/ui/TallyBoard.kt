package com.abyxcz.scorepad.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.Player
import com.abyxcz.scorepad.ui.component.ControlButtons
import com.abyxcz.scorepad.ui.component.HighEndScoreboard
import com.abyxcz.scorepad.ui.component.HighEndTileCounterColumn
import com.abyxcz.scorepad.ui.component.NavigationButtons
import com.abyxcz.scorepad.ui.component.TileCounterList
import com.abyxcz.scorepad.ui.component.UserNameInputForm

@Composable
fun TallyBoard(players: List<Player>, onClick: () -> Unit, onBack: () -> Unit, onCount: (player:Player, score: Int) -> Unit){
    var score by rememberSaveable { mutableStateOf(0)}

    Column {

        Box(
            modifier = Modifier
                .padding(vertical = 28.dp)

        ) {
            ControlButtons(
                "Reset Score", { score = 0 }, "Game Select", onBack, modifier = Modifier
                    .padding(vertical = 8.dp)
            )
        }

        Box(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxSize()
                .clickable { score += 1 }

        ) {

            SimpleScoreBoard(title = "Tally", value = score)
        }

    }
}

@Composable
fun SimpleScoreBoard(title: String, value: Int){

    HighEndScoreboard(title = title, value = value)

}


@Preview
@Composable
fun TallyBoardPreview(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null), Player("3", 3, Color(0xFF00FF00), null))

    TallyBoard(players = list, onClick = {}, onBack = {}, onCount = { _ , _ -> {} })
}