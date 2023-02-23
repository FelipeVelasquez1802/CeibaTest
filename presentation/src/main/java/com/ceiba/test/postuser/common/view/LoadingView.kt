package com.ceiba.test.postuser.common.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.postuser.ui.theme.PostUserTheme

@Composable
fun Loading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}


@Preview(showBackground = true)
@Composable
private fun LoadingPreview() {
    PostUserTheme {
        Loading()
    }
}