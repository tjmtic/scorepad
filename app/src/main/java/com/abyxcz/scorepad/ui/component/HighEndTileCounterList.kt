package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abyxcz.scorepad.Player

@Composable
fun HighEndTileCounterList(
    players: List<Player>,
    onCount: (player: Player, score: Int) -> Unit
) {

    val columnCount = calculateColumnCount(players.size)

    LazyVerticalGrid(
        columns = GridCells.Fixed(columnCount),
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {
        items(players.size) { index ->
            HighEndTileCounter(
                player = players[index],
                onCount = onCount,
                modifier = Modifier
                    //.padding(25.dp)
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun HighEndTileCounterColumn(
    players: List<Player>,
    onCount: (player: Player, score: Int) -> Unit
) {
    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp),

            ) {
            players.forEach { index ->
                HighEndTileCounter(
                    player = index,
                    onCount = onCount,
                    modifier = Modifier.padding(1.dp).weight(1f/players.size)
                )
            }

    }
}

@Composable
fun HighEndTileCounterLazyColumn(
    players: List<Player>,
    onCount: (player: Player, score: Int) -> Unit
) {
    val totalItems = players.size
    val rows = (totalItems + 1) / 2 // Calculate number of rows

    val AppBarHeight = 56.dp
    val availableHeight = (LocalDensity.current.density.dp - AppBarHeight) / rows // Calculate available height for each item

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(players.size) { index ->


            HighEndTileCounter(
                player = players[index],
                onCount = onCount,
                modifier = Modifier
                    .fillMaxWidth()
                    //.weight(1f)
            )
        }
    }
}

@Composable
fun HighEndTileCounter(
    player: Player,
    onCount: (player: Player, score: Int) -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium
) {
    var count by remember { mutableStateOf(0) }

    Card(
        modifier = modifier
            .clickable {
                count += 1
                onCount(player, 1)
            }
            .fillMaxSize()
            .background(
                color = player.color,
                //shape = shape
            )
            //.padding(16.dp)
    ) {
        Row {
            player.icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(22.dp),
            ) {
                Text("${player.name} ${player.score} ${player.color} ${player.icon} $count")
            }
        }
    }
}

private fun calculateColumnCount(itemCount: Int): Int {
    return when {
        itemCount <= 1 -> 1
        itemCount <= 2 -> 2
        itemCount <= 4 -> 2
        itemCount <= 9 -> 3
        itemCount <= 16 -> 4
        else -> 5 // You can adjust this logic according to your needs
    }
}

@Preview
@Composable
fun previewHighEndTileCounter(){
    HighEndTileCounter(player = Player("A", 0, Color(0xFF00FF00), null), onCount = { _, _->})
}

@Preview
@Composable
fun previewHighEnd(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null))
    MaterialTheme {
        HighEndTileCounterList(players = list, onCount = { _, _ -> })
    }
}

@Preview
@Composable
fun previewHighEnd3(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null), Player("3", 3, Color(0xFF00FF00), null))
    MaterialTheme {
        HighEndTileCounterList(players = list, onCount = { _, _ -> })
    }
}

@Preview
@Composable
fun previewHighEndColumn(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null))
    HighEndTileCounterColumn(players = list, onCount = {_,_->})
}

@Preview
@Composable
fun previewHighEndLazyColumn(){
    val list = listOf(Player("A", 0, Color(0xFF00FF00), null), Player("B", 2, Color(0xFF00FF00), null))
    HighEndTileCounterLazyColumn(players = list, onCount = {_,_->})
}

