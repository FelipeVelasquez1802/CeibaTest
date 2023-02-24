package com.ceiba.test.dataaccess.user.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.test.dataaccess.user.database.entity.UserEntity

@Dao
internal interface UserDao {
    @Query("""
        SELECT * FROM user 
        WHERE strftime('%Y-%m-%d', datetime(last_update/1000, 'unixepoch')) = strftime('%Y-%m-%d', 'now')
        """)
    fun getAll(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: UserEntity)
}