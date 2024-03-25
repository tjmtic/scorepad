package com.abyxcz.scorepad.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.abyxcz.scorepad.Player
import com.abyxcz.scorepad.ui.component.BouncingListItem
import com.abyxcz.scorepad.ui.component.NavigationButtons
import com.abyxcz.scorepad.ui.component.TileCounter
import com.abyxcz.scorepad.ui.component.UserNameInputForm

@Composable
fun NameScreen(players: List<Player>, onValue1Save: (String) -> Unit, onClick: () -> Unit, onBack: () -> Unit){
    //var name by rememberSaveable{ mutableStateOf("")}

    Column{
        UserNameInputForm(title = "Game Name", onSubmit = onValue1Save)
        /*TextField(value = name, onValueChange = { name = it } )
        //TextField(value= value2, onValueChange = { onValue2Change(it)} )

        Button( modifier = Modifier,
            onClick = { onValue1Save(name); name = "" }, content = {
                Text(text="Add Player")
            })*/

        Button( modifier = Modifier,
            onClick = { onClick()}, content = {
                Text(text="Play")
            })

        Button( modifier = Modifier,
            onClick = { onBack()}, content = {
                Text(text="Back")
            })

        NavigationButtons(onClick, onBack)


        LazyVerticalGrid(columns= GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
            itemsIndexed(players) { index, item ->
                BouncingListItem(item = item.name, isLoading = false, imageUrl = null)
            }
        }
    }


}