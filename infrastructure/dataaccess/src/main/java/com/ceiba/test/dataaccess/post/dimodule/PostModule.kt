package com.ceiba.test.dataaccess.post.dimodule

import com.ceiba.test.dataaccess.common.database.DatabaseConfig
import com.ceiba.test.dataaccess.post.repository.PostRepositoryImpl
import com.ceiba.test.domain.post.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal class PostModule {
    @Provides
    fun providePostRepository(database: DatabaseConfig): PostRepository =
        PostRepositoryImpl(database.postDao())
}