package com.ceiba.test.postuser.common.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.user.ui.theme.multiplierX8

@Composable
fun EmptyList(callToAction: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(multiplierX8),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "List is Empty",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = callToAction,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Reload")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyListPreview() {
    PostUserTheme {
        EmptyList()
    }
}