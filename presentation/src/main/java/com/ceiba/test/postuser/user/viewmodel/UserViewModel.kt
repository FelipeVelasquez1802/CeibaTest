package com.ceiba.test.postuser.user.viewmodel

import androidx.compose.runtime.mutableStateListOf
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.domain.user.service.UserService
import com.ceiba.test.postuser.common.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class UserViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    protected lateinit var userService: UserService

    val users: MutableList<User> = mutableStateListOf()

    fun executeGetUser() {
        showLoading.value = true
        CoroutineScope(IO).launch {
            val result = userService.consultUsers()
            users.clear()
            users.addAll(result)
            showLoading.value = false
        }
    }

}