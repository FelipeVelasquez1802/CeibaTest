package com.ceiba.test.dataaccess.post.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ceiba.test.dataaccess.common.database.entity.BaseEntity

internal const val POST_TABLE_NAME = "post"
internal const val USER_ID_KEY = "user_id"
@Entity(tableName = POST_TABLE_NAME)
internal data class PostEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = USER_ID_KEY) val userId: Int,
    val title: String,
    val body: String
):BaseEntity()