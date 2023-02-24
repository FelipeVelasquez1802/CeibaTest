package com.ceiba.test.dataaccess.post.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.test.dataaccess.common.database.entity.LAST_UPDATE_KEY
import com.ceiba.test.dataaccess.post.database.entity.POST_TABLE_NAME
import com.ceiba.test.dataaccess.post.database.entity.PostEntity
import com.ceiba.test.dataaccess.post.database.entity.USER_ID_KEY

@Dao
internal interface PostDao {
    @Query(
        """
        SELECT * FROM $POST_TABLE_NAME
         WHERE $USER_ID_KEY = :userId
         AND strftime('%Y-%m-%d', datetime($LAST_UPDATE_KEY/1000, 'unixepoch')) = strftime('%Y-%m-%d', 'now')
        """
    )
    fun getAllBy(userId: Int): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg posts: PostEntity)
}