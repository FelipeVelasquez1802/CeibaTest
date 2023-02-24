package com.ceiba.test.dataaccess.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ceiba.test.dataaccess.BuildConfig
import com.ceiba.test.dataaccess.post.database.dao.PostDao
import com.ceiba.test.dataaccess.post.database.entity.PostEntity
import com.ceiba.test.dataaccess.user.database.dao.UserDao
import com.ceiba.test.dataaccess.user.database.entity.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class], version = BuildConfig.VERSION_DATABASE)
internal abstract class DatabaseConfig : RoomDatabase() {
    abstract fun usersDao(): UserDao
    abstract fun postDao(): PostDao
}