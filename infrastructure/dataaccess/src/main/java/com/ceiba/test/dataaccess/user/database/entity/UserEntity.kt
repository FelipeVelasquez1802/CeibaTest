package com.ceiba.test.dataaccess.user.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ceiba.test.dataaccess.common.database.entity.BaseEntity

internal const val USER_TABLE_NAME = "user"

@Entity(tableName = USER_TABLE_NAME)
internal data class UserEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val email: String,
    val phone: String
) : BaseEntity()
