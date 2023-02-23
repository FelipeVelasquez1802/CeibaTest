package com.ceiba.test.dataaccess.user.api

import com.ceiba.test.dataaccess.user.dto.UserDto
import retrofit2.Call
import retrofit2.http.GET

internal interface UserApi {

    @GET("/users")
    fun getUsers(): Call<List<UserDto>>
}