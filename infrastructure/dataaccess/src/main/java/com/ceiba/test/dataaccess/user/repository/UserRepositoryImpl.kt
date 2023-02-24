package com.ceiba.test.dataaccess.user.repository

import com.ceiba.test.dataaccess.user.UserRemoteAdapter
import com.ceiba.test.dataaccess.common.database.DatabaseConfig
import com.ceiba.test.dataaccess.user.database.dao.UserDao
import com.ceiba.test.dataaccess.user.mapper.UserMapper
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.domain.user.repository.UserRepository
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {
    override fun select(): List<User> {
        var usersEntity = userDao.getAll()
        if (usersEntity.isEmpty()) {
            val users = UserRemoteAdapter().getUsers()
            usersEntity = UserMapper.fromListDtoToListEntity(users)
            userDao.insertAll(users = usersEntity.toTypedArray())
            return UserMapper.fromListDtoToListDomain(users)
        }
        return UserMapper.fromListEntityToListDomain(usersEntity)
    }
}