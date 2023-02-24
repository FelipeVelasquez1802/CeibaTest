package com.ceiba.test.dataaccess.post.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ceiba.test.dataaccess.common.database.entity.BaseEntity

@Entity(tableName = "post")
internal data class PostEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    val title: String,
    val body: String
):BaseEntity()