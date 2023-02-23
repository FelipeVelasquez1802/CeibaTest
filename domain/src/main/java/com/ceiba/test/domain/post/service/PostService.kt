package com.ceiba.test.domain.post.service

import com.ceiba.test.domain.exception.BadIdException
import com.ceiba.test.domain.post.model.Post
import com.ceiba.test.domain.post.repository.PostRepository
import javax.inject.Inject

class PostService @Inject constructor(private val postRepository: PostRepository) {

    fun consultPostsBy(userId: Int): List<Post> {
        if (userId <= 0) {
            throw BadIdException()
        }
        return postRepository.selectBy(userId)
    }
}