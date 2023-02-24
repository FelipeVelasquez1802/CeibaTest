package com.ceiba.test.dataaccess.user.repository

import com.ceiba.test.dataaccess.user.UserRemoteAdapter
import com.ceiba.test.dataaccess.user.database.dao.UserDao
import com.ceiba.test.dataaccess.user.dto.UserDto
import com.ceiba.test.dataaccess.user.mapper.UserMapper
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.domain.user.repository.UserRepository
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) :
    UserRepository {
    override fun select(): List<User> {
        val usersEntity = userDao.getAll()
        if (usersEntity.isEmpty()) {
            val users = UserRemoteAdapter().getUsers().insertLocal()
            return UserMapper.fromListDtoToListDomain(users)
        }
        return UserMapper.fromListEntityToListDomain(usersEntity)
    }

    private fun List<UserDto>.insertLocal() = this.apply {
        val usersEntity = UserMapper.fromListDtoToListEntity(this)
        userDao.insertAll(users = usersEntity.toTypedArray())
    }
}