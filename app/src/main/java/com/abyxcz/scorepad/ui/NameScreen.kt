package com.abyxcz.scorepad.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NameScreen(value1: String, onValue1Change: (String) -> Unit, value2: String, onValue2Change: (String) -> Unit, onClick: () -> Unit){

    Column{
        TextField(value= value1, onValueChange = { onValue1Change(it)} )
        TextField(value= value2, onValueChange = { onValue2Change(it)} )
        Button( modifier = Modifier,
            onClick = { onClick()}, content = {
                Text(text="Play")
            })
    }


}