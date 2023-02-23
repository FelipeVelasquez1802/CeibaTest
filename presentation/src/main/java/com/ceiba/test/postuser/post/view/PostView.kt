package com.ceiba.test.postuser.post.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.domain.post.model.Post
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.postuser.common.view.EmptyList
import com.ceiba.test.postuser.ui.theme.Green700
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.user.ui.theme.multiplierX4
import com.ceiba.test.postuser.user.view.User

@Composable
fun Posts(user: User, posts: List<Post>, updateList: () -> Unit) {
    LazyColumn {
        item {
            User(user = user, showCallToAction = false)
        }
        if (posts.isEmpty()) {
            item {
                EmptyList(callToAction = updateList)
            }
        } else {
            items(posts) { post -> Post(post = post) }
        }
    }
}

@Composable
private fun Post(post: Post) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(multiplierX4)) {
            val title = post.title
            Title(title = title)
            val body = post.body
            Body(body = body)
        }
    }
}

@Composable
private fun Title(title: String) {
    Text(text = title, style = MaterialTheme.typography.subtitle1, color = Green700)
}

@Composable
private fun Body(body: String) {
    Text(text = body, style = MaterialTheme.typography.body1)
}

@Preview(showBackground = true)
@Composable
private fun PostPreview() {
    PostUserTheme {
        val user = User(
            id = 1,
            name = "Example1",
            email = "example1@yopmail.com",
            phone = "3003003031"
        )
        val posts = listOf(
            Post(
                id = 1,
                title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                body = """
                quia et suscipit
                suscipit recusandae consequuntur expedita et cum
                reprehenderit molestiae ut ut quas totam
                nostrum rerum est autem sunt rem eveniet architecto
            """.trimIndent()
            )
        )
        Posts(user = user, posts = posts, updateList = {})
    }
}