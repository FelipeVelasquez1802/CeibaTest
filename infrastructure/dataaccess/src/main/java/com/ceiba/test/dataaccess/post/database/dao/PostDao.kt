package com.ceiba.test.dataaccess.post.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ceiba.test.dataaccess.post.database.entity.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM post WHERE user_id = :userId")
    fun getAllBy(userId: Int): List<PostEntity>

    @Insert
    fun insertAll(vararg posts: PostEntity)
}