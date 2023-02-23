package com.ceiba.test.domain.user.service

import com.ceiba.test.domain.user.repository.UserRepository
import javax.inject.Inject

class UserService @Inject constructor(private val userRepository: UserRepository) {

    fun consultUsers() = userRepository.select()
}