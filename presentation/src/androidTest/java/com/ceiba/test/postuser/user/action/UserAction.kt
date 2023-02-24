package com.ceiba.test.postuser.user.action

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.postuser.ui.theme.PostUserTheme
import com.ceiba.test.postuser.user.activity.MainView

class UserAction(private val composableTestRule: ComposeContentTestRule) {

    private val users = listOf(
        User(id = 1, name = "Example1", email = "example1@yopmail.com", phone = "3003003031"),
        User(id = 2, name = "Example2", email = "example2@yopmail.com", phone = "3003003032"),
        User(id = 3, name = "Example3", email = "example3@yopmail.com", phone = "3003003033"),
        User(id = 4, name = "Example4", email = "example4@yopmail.com", phone = "3003003034")
    )

    fun initView() {
        composableTestRule.setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                PostUserTheme {
                    MainView(users = users) {}
                }
            }
        }
    }

    fun inputTextFilter(text: String) {
        val tagFilter = "filter"
        val filter = composableTestRule.onNodeWithTag(tagFilter)
        filter.performTextInput(text)
    }

    fun validateListEmpty(){
        val tagTitleEmptyList = "titleEmptyList"
        val titleEmptyList = composableTestRule.onNodeWithTag(tagTitleEmptyList)
        titleEmptyList.assert(hasText("List is Empty"))
    }

    fun validateItems(){
        val tagItems = "fullName"
        val fullNameItem = composableTestRule.onNodeWithTag(tagItems)
        fullNameItem.assert(hasText("Example1"))
    }
}