package com.ceiba.test.domain.post.service

import com.ceiba.test.domain.exception.BadIdException
import com.ceiba.test.domain.post.repository.PostRepository
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostServiceTest {

    @Mock
    private lateinit var postRepository: PostRepository

    private lateinit var postService: PostService

    @Before
    fun setUp() {
        postService = PostService(postRepository)
    }

    @Test
    fun `Given the consult Post by UserId When is bad UserId Then return BadIdException`() {
        val badId = -1
        try {
            postService.consultPostsBy(userId = badId)
            fail("Expected ${BadIdException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is BadIdException)
        }
    }

    @Test
    fun `Given the consult Post by UserId When is good UserId Then return Posts or EmptyList`(){
        val userId = 1
        Mockito.`when`(postRepository.selectBy(userId)).thenReturn(emptyList())
        val posts = postService.consultPostsBy(userId)
        assertTrue(posts.isEmpty())
    }
}