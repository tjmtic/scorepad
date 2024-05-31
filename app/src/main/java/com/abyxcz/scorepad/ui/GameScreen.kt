package com.abyxcz.scorepad.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.abyxcz.scorepad.Player
import com.abyxcz.scorepad.data.Game

@Composable
fun GameScreen(gameSelection: Game?, players: List<Player>, onClick: () -> Unit, onBack: () -> Unit, onCount: (player:Player, score: Int) -> Unit){

    when(gameSelection) {
        is Game.Tally -> { TallyBoard(players = players, onClick = onClick, onBack = onBack, onCount = onCount) }
        is Game.TicTacToe -> { TicTacToeBoard(players = players, onClick = onClick, onBack = onBack, onCount = onCount) }
        is Game.Dominos ->  { DominoBoard(players = players, onClick = onClick, onBack = onBack, onCount = onCount) }
        else -> { TallyBoard(players = players, onClick = onClick, onBack = onBack, onCount = onCount) }
    }
}


@Preview
@Composable
fun GameScreenPreview(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null), Player("3", 3, Color(0xFF00FF00), null))

    GameScreen(Game.Tally("Tally 0!"), players = list, onClick = {}, onBack = {}, onCount = { _ , _ -> {} })
}

@Preview
@Composable
fun TicTacToeScreenPreview(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null), Player("3", 3, Color(0xFF00FF00), null))

    GameScreen(Game.TicTacToe(0), players = list, onClick = {}, onBack = {}, onCount = { _ , _ -> {} })
}

@Preview
@Composable
fun DominosScreenPreview(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null), Player("3", 3, Color(0xFF00FF00), null))

    GameScreen(Game.Dominos(4), players = list, onClick = {}, onBack = {}, onCount = { _ , _ -> {} })
}