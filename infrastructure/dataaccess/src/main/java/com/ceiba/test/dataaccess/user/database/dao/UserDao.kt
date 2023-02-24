package com.ceiba.test.dataaccess.user.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.test.dataaccess.common.database.entity.LAST_UPDATE_KEY
import com.ceiba.test.dataaccess.user.database.entity.USER_TABLE_NAME
import com.ceiba.test.dataaccess.user.database.entity.UserEntity

@Dao
internal interface UserDao {
    @Query(
        """
        SELECT * FROM $USER_TABLE_NAME 
        WHERE strftime('%Y-%m-%d', datetime($LAST_UPDATE_KEY/1000, 'unixepoch')) = strftime('%Y-%m-%d', 'now')
        """
    )
    fun getAll(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: UserEntity)
}