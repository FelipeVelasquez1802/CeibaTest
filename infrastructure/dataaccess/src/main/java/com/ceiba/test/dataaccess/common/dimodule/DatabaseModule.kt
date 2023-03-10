package com.ceiba.test.dataaccess.common.dimodule

import android.content.Context
import androidx.room.Room
import com.ceiba.test.dataaccess.common.database.DatabaseConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DatabaseConfig {
        val databaseName = "ceiba_test"
        return Room.databaseBuilder(context, DatabaseConfig::class.java, databaseName)
            .fallbackToDestructiveMigration().build()
    }
}