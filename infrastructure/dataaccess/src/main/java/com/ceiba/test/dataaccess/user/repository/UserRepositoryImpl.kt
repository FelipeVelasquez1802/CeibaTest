package com.ceiba.test.dataaccess.user.repository

import com.ceiba.test.dataaccess.user.UserRemoteAdapter
import com.ceiba.test.dataaccess.user.mapper.UserMapper
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.domain.user.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    override fun select(): List<User> {
        val users = UserRemoteAdapter().getUsers()
        return UserMapper.fromListDtoToListDomain(users)
    }
}