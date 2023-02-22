package com.ceiba.test.dataaccess.user

import com.ceiba.test.dataaccess.user.dto.UserDto

internal class UserRemoteAdapter {

    fun getUsers(): List<UserDto> = listOf(
        UserDto(name = "Example1", email = "example1@yopmail.com", phone = "3003003031"),
        UserDto(name = "Example2", email = "example2@yopmail.com", phone = "3003003032"),
        UserDto(name = "Example3", email = "example3@yopmail.com", phone = "3003003033"),
        UserDto(name = "Example4", email = "example4@yopmail.com", phone = "3003003034")
    )
}