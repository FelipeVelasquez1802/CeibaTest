package com.ceiba.test.postuser.common.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.postuser.R
import com.ceiba.test.postuser.ui.theme.BackgroundCard
import com.ceiba.test.postuser.ui.theme.Green700
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.ui.theme.multiplierX12

@Composable
fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCard),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(multiplierX12),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val textLoading = stringResource(id = R.string.loading)
            Text(
                text = textLoading,
                style = MaterialTheme.typography.h6,
                color = Green700,
                modifier = Modifier.padding(
                    start = multiplierX12,
                    bottom = multiplierX12,
                    end = multiplierX12
                )
            )
            CircularProgressIndicator()
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun LoadingPreview() {
    PostUserTheme {
        Loading()
    }
}