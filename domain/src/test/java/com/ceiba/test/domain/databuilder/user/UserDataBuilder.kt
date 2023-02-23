package com.ceiba.test.domain.databuilder.user

import com.ceiba.test.domain.user.model.User

internal class UserDataBuilder {
    private var id = 1
    private var name = "Example"
    private var email = "example@yopmail.com"
    private var phone = "300000000"

    fun withId(id: Int): UserDataBuilder = this.apply { this.id = id }

    fun withName(name: String): UserDataBuilder = this.apply { this.name = name }

    fun withEmail(email: String): UserDataBuilder = this.apply { this.email = email }

    fun withPhone(phone: String): UserDataBuilder = this.apply { this.phone = phone }

    fun build(): User = User(id, name, email, phone)
}