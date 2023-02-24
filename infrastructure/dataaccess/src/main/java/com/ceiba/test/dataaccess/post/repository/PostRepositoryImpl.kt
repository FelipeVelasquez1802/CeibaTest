package com.ceiba.test.dataaccess.post.repository

import com.ceiba.test.dataaccess.post.PostRemoteAdapter
import com.ceiba.test.dataaccess.post.database.dao.PostDao
import com.ceiba.test.dataaccess.post.mapper.PostMapper
import com.ceiba.test.domain.post.model.Post
import com.ceiba.test.domain.post.repository.PostRepository
import javax.inject.Inject

internal class PostRepositoryImpl @Inject constructor(private val postDao: PostDao) :
    PostRepository {
    override fun selectBy(userId: Int): List<Post> {
        var postsEntity = postDao.getAllBy(userId)
        if (postsEntity.isEmpty()) {
            val posts = PostRemoteAdapter().getPostsBy(userId)
            postsEntity = PostMapper.fromListDtoToListEntity(posts)
            postDao.insertAll(posts = postsEntity.toTypedArray())
            return PostMapper.fromListDtoToListDomain(posts)
        }
        return PostMapper.fromListEntityToListDomain(postsEntity)
    }

}