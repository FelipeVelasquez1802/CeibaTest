package com.ceiba.test.dataaccess.user.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ceiba.test.dataaccess.user.database.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

    @Insert
    fun insertAll(vararg users: UserEntity)
}