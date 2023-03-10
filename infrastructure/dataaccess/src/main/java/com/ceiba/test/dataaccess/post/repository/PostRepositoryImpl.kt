package com.ceiba.test.dataaccess.post.repository

import com.ceiba.test.dataaccess.post.PostRemoteAdapter
import com.ceiba.test.dataaccess.post.database.dao.PostDao
import com.ceiba.test.dataaccess.post.dto.PostDto
import com.ceiba.test.dataaccess.post.mapper.PostMapper
import com.ceiba.test.domain.post.model.Post
import com.ceiba.test.domain.post.repository.PostRepository
import javax.inject.Inject

internal class PostRepositoryImpl @Inject constructor(private val postDao: PostDao) :
    PostRepository {
    override fun selectBy(userId: Int): List<Post> {
        val postsEntity = postDao.getAllBy(userId)
        if (postsEntity.isEmpty()) {
            val posts = PostRemoteAdapter().getPostsBy(userId).insertLocal()
            return PostMapper.fromListDtoToListDomain(posts)
        }
        return PostMapper.fromListEntityToListDomain(postsEntity)
    }

    private fun List<PostDto>.insertLocal() = this.apply {
        val postsEntity = PostMapper.fromListDtoToListEntity(this)
        postDao.insertAll(posts = postsEntity.toTypedArray())
    }

}