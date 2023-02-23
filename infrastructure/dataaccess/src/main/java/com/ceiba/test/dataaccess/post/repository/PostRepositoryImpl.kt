package com.ceiba.test.dataaccess.post.repository

import com.ceiba.test.dataaccess.post.PostRemoteAdapter
import com.ceiba.test.dataaccess.post.mapper.PostMapper
import com.ceiba.test.domain.post.model.Post
import com.ceiba.test.domain.post.repository.PostRepository
import javax.inject.Inject

internal class PostRepositoryImpl @Inject constructor() : PostRepository {
    override fun selectBy(userId: Int): List<Post> {
        val posts = PostRemoteAdapter().getPostsBy(userId)
        return PostMapper.fromListDtoToListDomain(posts)
    }

}