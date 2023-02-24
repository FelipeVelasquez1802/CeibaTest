package com.ceiba.test.dataaccess.post.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.test.dataaccess.post.database.entity.PostEntity

@Dao
internal interface PostDao {
    @Query("""
        SELECT * FROM post
         WHERE user_id = :userId
         AND strftime('%Y-%m-%d', datetime(last_update/1000, 'unixepoch')) = strftime('%Y-%m-%d', 'now')
        """)
    fun getAllBy(userId: Int): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg posts: PostEntity)
}