package com.abyxcz.scorepad.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HighEndForm(
    onNameChanged: (String) -> Unit,
    onColorSelected: (Color) -> Unit,
    onIconSelected: (ImageVector) -> Unit,
    onSubmit: (String, Color, ImageVector) -> Unit,
    nameError: String? = null
) {

    var nameValue by remember { mutableStateOf("") }
    var colorValue by remember { mutableStateOf(Color(0)) }
    var iconValue by remember { mutableStateOf(ImageVector.Builder("",0.dp,0.dp,0f, 0f).build())}

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Name Field
        OutlinedTextField(
            value = nameValue,
            onValueChange = { nameValue = it },
            label = { Text("Name") },
            isError = nameError != null,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Name",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        )

        // Error Message
        nameError?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Color Selection Field
        ColorSelectionField(
            onColorSelected = { colorValue = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Icon Selection Field
        IconSelectionField(
            onIconSelected = { iconValue = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit Button
        Button(
            onClick = { onSubmit(nameValue, colorValue, iconValue) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Submit")
        }
    }
}

@Composable
fun ColorSelectionField(
    onColorSelected: (Color) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Magenta)

    Column(
        modifier = modifier
    ) {
        Text(
            text = "Select Color",
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            colors.forEach { color ->
                ColorSelectionItem(color = color) { onColorSelected(it) }
            }
        }
    }
}

@Composable
fun ColorSelectionItem(
    color: Color,
    onClick: (Color) -> Unit
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clickable { onClick(color) }
            .background(color = color, shape = CircleShape)
    )
}

@Composable
fun IconSelectionField(
    onIconSelected: (ImageVector) -> Unit,
    modifier: Modifier = Modifier
) {
    val icons = listOf(Icons.Default.Home, Icons.Default.Favorite, Icons.Default.Star)

    Column(
        modifier = modifier
    ) {
        Text(
            text = "Select Icon",
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            icons.forEach { icon ->
                IconSelectionItem(icon = icon) { onIconSelected(it) }
            }
        }
    }
}

@Composable
fun IconSelectionItem(
    icon: ImageVector,
    onClick: (ImageVector) -> Unit
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clickable { onClick(icon) }
    )
}

@Preview
@Composable

fun previewHighEndForm(){
    MaterialTheme{
        HighEndForm(
            onNameChanged = {},
            onColorSelected = {} ,
            onIconSelected = {},
            onSubmit = { _,_,_->/*TODO*/ })
    }
}
