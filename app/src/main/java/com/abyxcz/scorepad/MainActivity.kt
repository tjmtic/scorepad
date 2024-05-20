package com.abyxcz.scorepad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.abyxcz.scorepad.ui.GameScreen
import com.abyxcz.scorepad.ui.NameScreen
import com.abyxcz.scorepad.ui.TitleScreen
import com.abyxcz.scorepad.ui.component.SimpleAdContainer
import com.abyxcz.scorepad.ui.component.SimpleAdView
import com.abyxcz.scorepad.ui.component.TileCounterList
import com.abyxcz.scorepad.ui.theme.ScorepadTheme
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel: MainViewModel by viewModels()
        var uiState: MainViewModelUiState by mutableStateOf(MainViewModelUiState.TitleScreen)


        //TODO: Replace with navcontroller and routes
        lifecycleScope.launch{
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.uiState.onEach{ uiState = it }.collect{}
            }
        }

        setContent {
            ScorepadTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SimpleAdContainer {

                        val state by mainViewModel.state.collectAsState()

                        when (uiState) {

                            is MainViewModelUiState.TitleScreen -> {
                                TitleScreen({mainViewModel.goToNameScreen()}){ game -> mainViewModel.selectGame(game) }
                            }

                            is MainViewModelUiState.NameScreen -> {
                                NameScreen(state.players,
                                    { name, color, icon -> mainViewModel.createNewPlayer(name, color, icon) },
                                    { mainViewModel.goToGameScreen() },
                                    { mainViewModel.resetGame() },
                                    { player -> mainViewModel.removePlayer(player)})
                            }

                            is MainViewModelUiState.GameScreen -> {
                                GameScreen(state.gameSelection, state.players,
                                    { mainViewModel.goToNameScreen() },
                                    { mainViewModel.goToTitleScreen() },
                                    { player, score -> mainViewModel.updatePlayer(player, score)}
                                )
                            }

                            else -> {}
                        }
                    }
                }
            }
        }

        MobileAds.initialize(this) {}
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello edit $name!",
        modifier = modifier
    )
}



@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Tile(tile: TicTacToeTile, onClick: () -> Unit){

    Box(Modifier.clickable { onClick() }) {
        when (tile.value) {
            1 -> {
                Text("X")
            }

            2 -> {
                Text("O")
            }

            else -> {
                Text("")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScorepadTheme {
        Greeting("Android")
    }
}