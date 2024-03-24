package com.abyxcz.scorepad.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abyxcz.scorepad.ui.component.SimpleAdContainer
import com.abyxcz.scorepad.ui.component.SimpleAdView

@Composable
fun TitleScreen(onClick: () -> Unit ){
    SimpleAdContainer {

        Column {

            SimpleAdView()

            Text(text = "Tic Tac Toe")
            Button(modifier = Modifier,
                onClick = { onClick() }, content = {
                    Text(text = "Play")
                })
        }
    }
}

@Preview
@Composable
fun PreviewTitleScreen(){
    TitleScreen({})
}