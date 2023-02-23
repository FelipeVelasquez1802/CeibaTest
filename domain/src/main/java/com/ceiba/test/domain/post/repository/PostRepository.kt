package com.ceiba.test.domain.post.repository

import com.ceiba.test.domain.post.model.Post

interface PostRepository {
    fun selectBy(userId: Int): List<Post>
}