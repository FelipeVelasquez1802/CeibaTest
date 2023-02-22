package com.ceiba.test.dataaccess.user.mapper

import com.ceiba.test.dataaccess.user.dto.UserDto
import com.ceiba.test.domain.user.model.User

internal object UserMapper {
    private fun fromDtoToDomain(dto: UserDto): User = User(dto.name, dto.email, dto.phone)

    fun fromListDtoToListDomain(listDto: List<UserDto>): List<User> =
        listDto.map { fromDtoToDomain(it) }
}