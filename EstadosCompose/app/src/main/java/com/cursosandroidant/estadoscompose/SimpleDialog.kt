package com.cursosandroidant.estadoscompose

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MySimpleDialog(show: Boolean, confirm: () -> Unit, dismiss: () -> Unit) {
    if (show) {

        AlertDialog(
            onDismissRequest = { },
            confirmButton = { TextButton(onClick = { confirm() }) { Text(text = "Print log") } },
            dismissButton = { TextButton(onClick = { dismiss() }) { Text(text = "Close") } },
            title = {
                Text(
                    text = "Title"
                )
            },
            text = { Text(text = "My favorite band is Imagine Dragons <3") })
    }


}