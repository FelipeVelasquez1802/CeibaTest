package com.ceiba.test.postuser.user.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.postuser.R
import com.ceiba.test.postuser.ui.theme.Green700
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.user.router.UserRouter
import com.ceiba.test.postuser.user.ui.theme.multiplierX12
import com.ceiba.test.postuser.user.ui.theme.multiplierX4
import com.ceiba.test.postuser.user.ui.theme.multiplierX8

@Composable
fun Users(users: List<User>) {
    LazyColumn(modifier = Modifier.padding(horizontal = multiplierX8)) {
        items(users) { user -> User(user = user) }
    }
}

@Composable
fun User(user: User, showCallToAction: Boolean = true) {
    Card(
        elevation = multiplierX4,
        modifier = Modifier
            .padding(vertical = multiplierX8)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(multiplierX4)) {
            val name = user.name
            FullName(name = name)
            val phone = user.phone
            Phone(phone = phone)
            val email = user.email
            Email(email = email)
            if (showCallToAction) {
                CallToAction(user = user, modifier = Modifier.align(Alignment.End))
            }
        }
    }
}

@Composable
private fun FullName(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h4,
        color = Green700
    )
}

@Composable
private fun Phone(phone: String) {
    Row {
        val phoneIcon = painterResource(id = R.drawable.ic_phone_24)
        Icon(painter = phoneIcon, contentDescription = null, tint = Green700)
        Text(
            text = phone,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
private fun Email(email: String) {
    Row {
        val mailIcon = painterResource(id = R.drawable.ic_mail_24)
        Icon(painter = mailIcon, contentDescription = null, tint = Green700)
        Text(
            text = email,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
private fun CallToAction(user: User, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val showPost = stringResource(id = R.string.show_post)
    Text(
        text = showPost,
        modifier = modifier
            .padding(vertical = multiplierX12)
            .clickable {
                UserRouter.goToPost(context, user)
            },
        color = Green700
    )
}

@Preview(showBackground = true)
@Composable
private fun UserPreview() {
    PostUserTheme {
        val users = listOf(
            User(id = 1, name = "Example1", email = "example1@yopmail.com", phone = "3003003031"),
            User(id = 2, name = "Example2", email = "example2@yopmail.com", phone = "3003003032"),
            User(id = 3, name = "Example3", email = "example3@yopmail.com", phone = "3003003033"),
            User(id = 4, name = "Example4", email = "example4@yopmail.com", phone = "3003003034")
        )
        Users(users = users)
    }
}