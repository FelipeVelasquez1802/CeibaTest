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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.postuser.R
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.ui.theme.multiplierX8

@Composable
fun EmptyList(callToAction: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(multiplierX8),
        verticalArrangement = Arrangement.Center
    ) {
        val emptyListText = stringResource(id = R.string.empty_list)
        Text(
            text = emptyListText,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .testTag("titleEmptyList")
        )
        val reloadText = stringResource(id = R.string.reload)
        Button(
            onClick = callToAction,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = reloadText)
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