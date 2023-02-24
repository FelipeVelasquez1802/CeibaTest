package com.ceiba.test.postuser.user

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ceiba.test.postuser.user.action.UserAction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class UserInstrumentedTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    private val action by lazy { UserAction(composableTestRule) }

    @Test
    fun givenFilterList_whenUnknownKey_thenReturnEmptyListMessage() {
        val filterValue = "Unknown text"
        action.initView()
        action.inputTextFilter(filterValue)
        action.validateListEmpty()
    }

    @Test
    fun givenFilerList_whenIsExample1Text_thenReturnItem(){
        val filterValue = "Example1"
        action.initView()
        action.inputTextFilter(filterValue)
        action.validateItems()
    }
}