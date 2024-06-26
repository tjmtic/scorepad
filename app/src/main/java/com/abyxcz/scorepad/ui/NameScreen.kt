package com.abyxcz.scorepad.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.abyxcz.scorepad.Player
import com.abyxcz.scorepad.R
import com.abyxcz.scorepad.ui.component.BouncingListItem
import com.abyxcz.scorepad.ui.component.HighEndForm
import com.abyxcz.scorepad.ui.component.HighEndListItem
import com.abyxcz.scorepad.ui.component.NavigationButtons
import com.abyxcz.scorepad.ui.component.TileCounter
import com.abyxcz.scorepad.ui.component.UserNameInputForm

@Composable
fun NameScreen(players: List<Player>, onValue1Save: (String, Color, ImageVector) -> Unit,
               onClick: () -> Unit, onBack: () -> Unit, onRemove: (Player) -> Unit){
    //var name by rememberSaveable{ mutableStateOf("")}

    Column{
        HighEndForm(
            onNameChanged = {},
            onColorSelected = {},
            onIconSelected = {} ,
            onSubmit = onValue1Save
        )

        //UserNameInputForm(title = "Game Name", onSubmit = onValue1Save)
        /*TextField(value = name, onValueChange = { name = it } )
        //TextField(value= value2, onValueChange = { onValue2Change(it)} )

        Button( modifier = Modifier,
            onClick = { onValue1Save(name); name = "" }, content = {
                Text(text="Add Player")
            })*/

        /*Button( modifier = Modifier,
            onClick = { onClick()}, content = {
                Text(text="Play")
            })

        Button( modifier = Modifier,
            onClick = { onBack()}, content = {
                Text(text="Back")
            })*/

        NavigationButtons(onClick, onBack)


        LazyVerticalGrid(columns= GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
            itemsIndexed(players) { index, item ->
                BouncingListItem(item = item.name, isLoading = false, imageUrl = null)
                Box(modifier = Modifier.clickable{ onRemove(item) }) {
                    HighEndListItem(
                        imageUrl = R.mipmap.bg2,
                        title = item.name,
                        specialDetail = "Player X",
                    )
                }
                }
        }
    }


}

@Preview
@Composable
fun PreviewNameScreen(){
    MaterialTheme {
        NameScreen(emptyList(), {_, _,_->}, {}, {}, {})
    }
}