package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun TileCounter(){

    var count by rememberSaveable { mutableStateOf(0) }

    Box(Modifier.clickable { count += 1 }) {
        Text(count.toString())
    }
}