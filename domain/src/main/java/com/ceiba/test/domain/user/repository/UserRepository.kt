package com.ceiba.test.domain.user.repository

import com.ceiba.test.domain.user.model.User

interface UserRepository {
    fun select(): List<User>
}