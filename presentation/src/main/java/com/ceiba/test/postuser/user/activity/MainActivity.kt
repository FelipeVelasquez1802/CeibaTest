package com.ceiba.test.postuser.user.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.user.ui.theme.multiplierX8
import com.ceiba.test.postuser.user.view.Users
import com.ceiba.test.postuser.user.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel.executeGetUser()
        setContent {
            PostUserTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val users = userViewModel.users
                    MainView(users)
                }
            }
        }
    }
}

@Composable
fun MainView(users: List<User>) {
    Column(
        modifier = Modifier.padding(horizontal = multiplierX8)
    ) {
        val usersFilter = remember {
            mutableStateListOf<User>().apply {
                addAll(users)
            }
        }
        val search: (value: String) -> Unit = { value ->
            val result = users.filter { it.name.lowercase(Locale.ROOT).contains(value) }
            usersFilter.apply {
                clear()
                addAll(result)
            }
        }
        FieldSearch(search)
        Users(users = usersFilter)
    }
}

@Composable
private fun FieldSearch(search: (value: String) -> Unit) {
    var text by remember { mutableStateOf("") }
    println(text)
    TextField(
        value = text,
        onValueChange = {
            search.invoke(it)
            text = it
        },
        label = {
            Text(text = "Buscar usuario")
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PostUserTheme {
        val users = listOf(
            User(name = "Example1", email = "example1@yopmail.com", phone = "3003003031"),
            User(name = "Example2", email = "example2@yopmail.com", phone = "3003003032"),
            User(name = "Example3", email = "example3@yopmail.com", phone = "3003003033"),
            User(name = "Example4", email = "example4@yopmail.com", phone = "3003003034")
        )
        MainView(users = users)
    }
}