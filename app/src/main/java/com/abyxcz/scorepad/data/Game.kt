package com.abyxcz.scorepad.data

import com.abyxcz.scorepad.R

sealed interface Game {

    data class Tally(val title: String) : Game
    data class TicTacToe(val players: Int): Game
    data class Dominos(val players: Int): Game
    data class Basketball(val players: Int, val names: String): Game
    data class Bowling(val players: Int, val frames: Int): Game
    data class Darts(val rounds: String, val score: String): Game
    data class Boxing(val overunder: Double): Game
    //Bets?
    //Ping Pong
    //Airhockey / Shuffleboard
    //Tennis

    //CUSTOM
}

data class GameProperties(val name: String, val image: Int)

fun Game.getProperties() : GameProperties {
    return when(this){
        is Game.Tally -> GameProperties("Tally", R.mipmap.tally)
        is Game.TicTacToe -> GameProperties("TicTacToe", R.mipmap.bg1)
        is Game.Basketball -> GameProperties("Basketball", R.mipmap.basketball)
        is Game.Bowling -> TODO()
        is Game.Boxing -> TODO()
        is Game.Darts -> TODO()
        is Game.Dominos -> GameProperties("Dominos", R.mipmap.bg2)
    }
}

//GAME.EXT
//Extension Properties
val Game.displayName: String
    get() = when (this) {
        //is Game.TicTacToe -> "Tic-Tac-Toe"
        is Game.Tally -> "Tally"
        is Game.Dominos -> "Dominos ($players players)"
        is Game.Basketball -> "Basketball ($players players $names names)"
        is Game.Bowling -> TODO()
        is Game.Boxing -> TODO()
        is Game.Darts -> TODO()
        is Game.TicTacToe -> "TIC Tac TOE"
    }