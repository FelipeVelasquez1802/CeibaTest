package com.ceiba.test.dataaccess.user.dimodule

import com.ceiba.test.dataaccess.common.database.DatabaseConfig
import com.ceiba.test.dataaccess.user.repository.UserRepositoryImpl
import com.ceiba.test.domain.user.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal class UserModule {

    @Provides
    fun provideUserRepository(database: DatabaseConfig): UserRepository =
        UserRepositoryImpl(database.usersDao())
}