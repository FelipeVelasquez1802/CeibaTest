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
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.postuser.R
import com.ceiba.test.postuser.common.view.Loading
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.ui.theme.multiplierX8
import com.ceiba.test.postuser.user.view.Users
import com.ceiba.test.postuser.user.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

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
                    val updateList = { recreate() }
                    MainView(users, updateList)
                    val loading = userViewModel.showLoading
                    if (loading.value) {
                        Loading()
                    }
                }
            }
        }
    }
}

@Composable
 fun MainView(users: List<User>, updateList: () -> Unit) {
    Column {
        val usersFilter = users.toMutableStateList()
        val search: (value: String) -> Unit = { value ->
            val result = users.filter { it.name.contains(value, ignoreCase = true) }
            usersFilter.apply {
                clear()
                addAll(result)
            }
        }
        AppBar()
        FieldSearch(search)
        Users(users = usersFilter, updateList)
    }
}

@Composable
private fun AppBar() {
    val title = stringResource(id = R.string.title_main)
    TopAppBar(
        title = {
            Text(text = title)
        },
        modifier = Modifier.padding(bottom = multiplierX8)
    )
}

@Composable
private fun FieldSearch(search: (value: String) -> Unit) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            search.invoke(it)
            text = it
        },
        label = {
            val text = stringResource(id = R.string.search_user)
            Text(text = text)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = multiplierX8)
            .testTag("filter")
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PostUserTheme {
        val users = listOf(
            User(id = 1, name = "Example1", email = "example1@yopmail.com", phone = "3003003031"),
            User(id = 2, name = "Example2", email = "example2@yopmail.com", phone = "3003003032"),
            User(id = 3, name = "Example3", email = "example3@yopmail.com", phone = "3003003033"),
            User(id = 4, name = "Example4", email = "example4@yopmail.com", phone = "3003003034")
        )
        MainView(users = users, updateList = {})
    }
}