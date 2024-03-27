package com.abyxcz.scorepad.ui.component

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abyxcz.scorepad.R

@Composable
fun FullViewListItem(
    imageUrl: Int?,
    title: String,
    specialDetail: String,
   // onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            //.clickable(onClick = onClick)
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Title and Special Detail
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Image
            imageUrl?.let {
                Image(
                    painter = painterResource(id = it), // Load image from resources
                    contentDescription = title, // Provide content description
                    contentScale = ContentScale.Fit, // Fit image within the space
                    modifier = Modifier
                        .size(72.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = specialDetail,
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp
                ),
                color = Color.Blue
            )
        }
    }
}

@Composable
fun HighEndTile(
    title: String,
    imageUrl: Int?,
    specialDetail: String
) {
    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxSize()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .scale(scale = 1.5f)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Image
            imageUrl?.let {
                Image(
                    painter = painterResource(id = it), // Load image from resources
                    contentDescription = title, // Provide content description
                    contentScale = ContentScale.Fit, // Fit image within the space
                    modifier = Modifier
                        .size(72.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .scale(scale = 1.5f)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = specialDetail,
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp
                ),
                color = Color.Blue,
                modifier = Modifier
                    .scale(scale = 1.5f)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun previewFullViewListItem(){
    MaterialTheme {
        FullViewListItem(
            imageUrl = R.mipmap.bg1,
            title = "Title",
            specialDetail = "Special Details"
        ) //{
        //}
    }
}

@Preview
@Composable
fun previewHighEndItem(){
    MaterialTheme {
        HighEndTile(
            imageUrl = R.mipmap.bg1,
            title = "Title",
            specialDetail = "Special Details"
        ) //{
        //}
    }
}