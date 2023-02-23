package com.ceiba.test.domain.post.model

import com.ceiba.test.domain.databuilder.post.PostDataBuilder
import com.ceiba.test.domain.exception.BadIdException
import com.ceiba.test.domain.exception.EmptyValueException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class PostTest {

    @Test
    fun `Given the creation of a Post When is bad Id Then return BadIdException`() {
        val badId = -1
        val dataBuilder = PostDataBuilder().withId(badId)
        try {
            dataBuilder.build()
            fail("Expected ${BadIdException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is BadIdException)
        }
    }

    @Test
    fun `Given the creation of a Post When is empty Title Then return EmptyValueException`() {
        val emptyTitle = ""
        val dataBuilder = PostDataBuilder().withTitle(emptyTitle)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation of a Post When is empty Body Then return EmptyValueException`() {
        val emptyBody = ""
        val dataBuilder = PostDataBuilder().withTitle(emptyBody)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation of a Post When is correct fields Then return Object`() {
        val id = 1
        val title = "Example"
        val body = "Body example"
        val post = PostDataBuilder()
            .withId(id)
            .withTitle(title)
            .withBody(body)
            .build()
        assertEquals(id, post.id)
        assertEquals(title, post.title)
        assertEquals(body, post.body)
    }
}