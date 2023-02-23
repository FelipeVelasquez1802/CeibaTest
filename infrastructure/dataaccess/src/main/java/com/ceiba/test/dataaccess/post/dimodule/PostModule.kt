package com.ceiba.test.dataaccess.post.dimodule

import com.ceiba.test.dataaccess.post.repository.PostRepositoryImpl
import com.ceiba.test.domain.post.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PostModule {
    @Provides
    fun providePostRepository(): PostRepository = PostRepositoryImpl()
}