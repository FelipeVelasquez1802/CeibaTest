package com.ceiba.test.dataaccess.user.api

import com.ceiba.test.dataaccess.user.dto.UserDto
import retrofit2.Call
import retrofit2.http.GET

private const val USER_PATH = "/users"
internal interface UserApi {

    @GET(USER_PATH)
    fun getUsers(): Call<List<UserDto>>
}