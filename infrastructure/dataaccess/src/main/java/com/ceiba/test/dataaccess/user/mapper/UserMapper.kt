package com.ceiba.test.dataaccess.user.mapper

import com.ceiba.test.dataaccess.user.database.entity.UserEntity
import com.ceiba.test.dataaccess.user.dto.UserDto
import com.ceiba.test.domain.user.model.User

internal object UserMapper {
    private fun fromDtoToDomain(dto: UserDto): User = User(dto.id, dto.name, dto.email, dto.phone)

    fun fromListDtoToListDomain(listDto: List<UserDto>): List<User> =
        listDto.map { fromDtoToDomain(it) }

    private fun fromEntityToDomain(entity: UserEntity): User =
        User(entity.id, entity.name, entity.email, entity.phone)

    fun fromListEntityToListDomain(listEntity: List<UserEntity>): List<User> =
        listEntity.map { fromEntityToDomain(it) }

    private fun fromDtoToEntity(dto: UserDto): UserEntity =
        UserEntity(dto.id, dto.name, dto.email, dto.phone)

    fun fromListDtoToListEntity(listDto: List<UserDto>): List<UserEntity> =
        listDto.map { fromDtoToEntity(it) }
}