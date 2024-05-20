package com.abyxcz.scorepad.data

sealed interface Game {

    val defaults: Pair<String, Int?> //name, image
    //data class Games(val name:String, val imageUrl: Int?): Game


    data class Tally(val title: String, override val defaults: Pair<String, Int?> = Pair("Tally", 0)) : Game
    data class Dominos(val players: Int, override val defaults: Pair<String, Int?> = Pair("Dominos", 0)): Game
    data class Basketball(val players: Int, val names: String, override val defaults: Pair<String, Int?> = Pair("Basketball", 0)): Game
    data class Bowling(val players: Int, val frames: Int, override val defaults: Pair<String, Int?> = Pair("Bowling", 0)): Game
    data class Darts(val rounds: String, val score: String, override val defaults: Pair<String, Int?> = Pair("Darts", 0)): Game
    data class Boxing(val overunder: Double, override val defaults: Pair<String, Int?> = Pair("Boxing", 0)): Game
    //Bets?
    //Ping Pong
    //Airhockey / Shuffleboard
    //Tennis

    //CUSTOM
}


///////////////////
//Unnecessary from defaults in interface

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
    }