package com.ceiba.test.postuser.user.mapper

import com.ceiba.test.domain.user.model.User
import com.ceiba.test.postuser.user.model.UserView

internal object UserMapper {
    fun fromDomainToView(user: User): UserView =
        UserView(user.id, user.name, user.email, user.phone)

    fun fromViewToDomain(user: UserView): User =
        User(user.id, user.name, user.email, user.phone)
}