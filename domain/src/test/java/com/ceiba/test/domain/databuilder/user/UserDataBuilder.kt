package com.ceiba.test.domain.databuilder.user

import com.ceiba.test.domain.user.model.User

internal class UserDataBuilder {
    private var name = "Example"
    private var email = "example@yopmail.com"
    private var phone = "300000000"

    fun withName(name: String): UserDataBuilder = this.apply { this.name = name }

    fun withEmail(email: String): UserDataBuilder = this.apply { this.email = email }

    fun withPhone(phone: String): UserDataBuilder = this.apply { this.phone = phone }

    fun build(): User = User(name, email, phone)
}