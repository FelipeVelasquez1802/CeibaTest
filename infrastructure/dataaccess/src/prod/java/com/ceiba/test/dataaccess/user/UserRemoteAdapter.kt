package com.ceiba.test.dataaccess.user

import com.ceiba.test.dataaccess.common.api.ConfigApi
import com.ceiba.test.dataaccess.user.api.UserApi
import com.ceiba.test.dataaccess.user.dto.UserDto

internal class UserRemoteAdapter {
    private val api = ConfigApi.getApi(UserApi::class.java)
    fun getUsers(): List<UserDto> {
        val usersDtoCall = api.getUsers()
        val usersDtoResponse = usersDtoCall.execute()
        return usersDtoResponse.body().orEmpty()
    }
}