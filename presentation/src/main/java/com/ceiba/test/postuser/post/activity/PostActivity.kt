package com.ceiba.test.postuser.post.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.domain.post.model.Post
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.postuser.R
import com.ceiba.test.postuser.common.view.EmptyList
import com.ceiba.test.postuser.common.view.Loading
import com.ceiba.test.postuser.post.view.Posts
import com.ceiba.test.postuser.post.viewmodel.PostViewModel
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.user.mapper.UserMapper
import com.ceiba.test.postuser.user.model.KeyField
import com.ceiba.test.postuser.user.model.UserView
import com.ceiba.test.postuser.ui.theme.multiplierX4
import com.ceiba.test.postuser.ui.theme.multiplierX8
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : ComponentActivity() {

    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = intent.getUser(KeyField.NAME.name)
        postViewModel.executeGetPostBy(user?.id.orZero())
        setContent {
            PostUserTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val posts = postViewModel.post
                    val updateList = { recreate() }
                    PostView(user, posts, updateList)
                    val showLoading = postViewModel.showLoading
                    if (showLoading.value) {
                        Loading()
                    }
                }
            }
        }
    }

    private fun Intent.getUser(key: String): User? {
        val userView: UserView? = extras?.getParcelable(key)
        return userView?.let { UserMapper.fromViewToDomain(it) }
    }

    private fun Int?.orZero(): Int = this ?: 0
}

@Composable
fun PostView(user: User?, posts: List<Post>, updateList: () -> Unit) {
    val context = LocalContext.current
    Column {
        val backArrowIcon = painterResource(id = R.drawable.ic_arrow_back_24)
        Icon(
            painter = backArrowIcon,
            contentDescription = "",
            modifier = Modifier
                .padding(multiplierX4, top = multiplierX8)
                .clickable {
                    close(context)
                }
        )
        if (user != null) {
            Posts(user = user, posts = posts, updateList)
        } else {
            EmptyList()
        }
    }
}

private fun close(context: Context) {
    when (context) {
        is PostActivity -> context.finish()
        else -> Unit
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
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
                userId = user.id,
                title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                body = """
                quia et suscipit
                suscipit recusandae consequuntur expedita et cum
                reprehenderit molestiae ut ut quas totam
                nostrum rerum est autem sunt rem eveniet architecto
            """.trimIndent()
            )
        )
        PostView(user, posts, updateList = {})
    }
}