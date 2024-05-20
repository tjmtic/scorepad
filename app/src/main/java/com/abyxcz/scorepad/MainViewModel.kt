package com.abyxcz.scorepad

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abyxcz.scorepad.data.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import java.io.Serializable

class MainViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<MainViewModelUiState>(MainViewModelUiState.TitleScreen)
    val uiState: StateFlow<MainViewModelUiState> = _uiState.stateIn(
        scope = viewModelScope, initialValue =
        MainViewModelUiState.TitleScreen,
        started = SharingStarted.WhileSubscribed(5000)
    )

    private val _state = MutableStateFlow<MainViewModelState>(MainViewModelState())
    val state: StateFlow<MainViewModelState> = _state.stateIn(
        scope = viewModelScope, initialValue =
        MainViewModelState(),
        started = SharingStarted.WhileSubscribed(5000)
    )

    private fun onEvent(event: MainViewModelEvent){
        when(event){
            is MainViewModelEvent.ResetEvent -> { _uiState.update{ MainViewModelUiState.TitleScreen } }
            is MainViewModelEvent.BeginEvent -> { _uiState.update{ MainViewModelUiState.NameScreen } }
            is MainViewModelEvent.GameSelectionEvent -> { _state.update{ it.copy(gameSelection = event.game) } }
            is MainViewModelEvent.GameResetEvent -> { _state.update{ it.copy(gameSelection = null) } }

            //is MainViewModelEvent.NameOneUpdateEvent -> { _state.update{ it.copy(nameOne = event.name) } }
            //is MainViewModelEvent.NameTwoUpdateEvent -> { _state.update{ it.copy(nameTwo = event.name) } }
            is MainViewModelEvent.AddPlayerEvent -> { _state.update{ it.copy(players = it.players.plus(event.player)) } }
            is MainViewModelEvent.RemovePlayerEvent -> { _state.update{ it.copy(players = it.players.minus(event.player)) } }
            is MainViewModelEvent.UpdatePlayerEvent -> { /* TODO */ }
            is MainViewModelEvent.GameStartEvent -> { _uiState.update{ MainViewModelUiState.GameScreen } }


            is MainViewModelEvent.TileUpdateEvent -> { /* selectTile(event.index) */ }
            is MainViewModelEvent.GameFinishedEvent -> { /* show winning dialogs */ }
        }
    }

    //Title Screen
    fun selectGame(game: Game){
        onEvent(MainViewModelEvent.GameSelectionEvent(game))
        goToNameScreen()
    }

    fun resetGame(){
        onEvent(MainViewModelEvent.GameResetEvent)
        goToTitleScreen()
    }

    fun goToTitleScreen(){
        onEvent(MainViewModelEvent.ResetEvent)
    }

    fun goToNameScreen(){
        onEvent(MainViewModelEvent.BeginEvent)
    }



    //Name Screen
    /*fun updateNameOne(name: String){
        onEvent(MainViewModelEvent.NameOneUpdateEvent(name))
    }

    fun updateNameTwo(name: String){
        onEvent(MainViewModelEvent.NameTwoUpdateEvent(name))
    }*/

    fun createNewPlayer(name: String, color: Color, icon: ImageVector){
        //Default init
        val newPlayer = Player(name, 0, color, icon)
        //

        onEvent(MainViewModelEvent.AddPlayerEvent(newPlayer))
    }

    fun goToGameScreen(){
        onEvent(MainViewModelEvent.GameStartEvent)
    }

    fun removePlayer(player: Player){
        onEvent(MainViewModelEvent.RemovePlayerEvent(player))
    }


    //Game Screen

    fun updatePlayer(player: Player, update: Int){
        println("updating player 1...")

        //Atomic / Thread-safe State Value Update
        _state.update{ it ->
            //var playerList: List<Player> = it.players.toMutableList()
            println("updating player 2...")
            val playerList: List<Player> = it.players.map { curPlayer ->
                println("updating player 3...${curPlayer.name}")
                if(curPlayer.name == player.name){
                    //Is this necessary for concurrency?
                    println("updating player 3a...${curPlayer.name}")

                    //Player(player.name, curPlayer.score + update, player.color, player.icon)

                    player.copy(score = curPlayer.score + update)
                }
                else curPlayer
            }

            println("updating player 4...")

            it.copy(players = playerList)
        }
    }

    fun updateTile(index: Int){
        onEvent(MainViewModelEvent.TileUpdateEvent(index))
    }

    /*fun selectTile(index: Int){

        _state.update {
            if(it.tiles[index].value == 0) {
                it.copy(
                    turn = !it.turn,
                    tiles = it.tiles.apply { this[index].value = if (it.turn) 1 else 2 },
                    finished = checkBoard())
            }

            else it
        }

        if(checkBoard()){
            finishGame()
        }
    }*/

    private fun checkBoard(): Boolean{
        //search board spaces...
        return false
    }

    private fun finishGame(){
        onEvent(MainViewModelEvent.GameFinishedEvent)
    }


}

data class TicTacToeTile(var value:Int = 0)

data class MainViewModelState (
    val gameSelection: Game? = null,
    val players : List<Player> = emptyList(),
    //val tiles : List<TicTacToeTile> = mutableListOf<TicTacToeTile>().apply{ repeat(9){ this.add(
    //    TicTacToeTile()
    //)}},
    val turn : Boolean = true,
    val finished: Boolean = false
) : Serializable

sealed interface MainViewModelEvent{
    object ResetEvent: MainViewModelEvent
    object BeginEvent: MainViewModelEvent
    data class GameSelectionEvent(val game: Game): MainViewModelEvent
    object GameResetEvent: MainViewModelEvent
    data class AddPlayerEvent(val player: Player): MainViewModelEvent
    data class UpdatePlayerEvent(val player: Player, val scoreUpdate: Int): MainViewModelEvent
    data class RemovePlayerEvent(val player: Player): MainViewModelEvent
    object GameStartEvent: MainViewModelEvent
    data class TileUpdateEvent(val index: Int): MainViewModelEvent
    object GameFinishedEvent: MainViewModelEvent
}

sealed interface MainViewModelUiState{
    object TitleScreen: MainViewModelUiState
    object NameScreen: MainViewModelUiState
    object GameScreen: MainViewModelUiState
}

data class Player(val name: String, val score: Int, val color: Color, val icon: ImageVector?)
