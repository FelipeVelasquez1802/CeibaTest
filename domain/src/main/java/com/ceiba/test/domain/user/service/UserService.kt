package com.ceiba.test.domain.user.service

import com.ceiba.test.domain.user.repository.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun consultUsers() = userRepository.select()
}