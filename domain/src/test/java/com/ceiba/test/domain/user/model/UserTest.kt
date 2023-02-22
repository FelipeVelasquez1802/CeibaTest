package com.ceiba.test.domain.user.model

import com.ceiba.test.domain.databuilder.user.UserDataBuilder
import com.ceiba.test.domain.exception.BadEmailException
import com.ceiba.test.domain.exception.EmptyValueException
import org.junit.Assert.*
import org.junit.Test

internal class UserTest {
    @Test
    fun `Given the creation of a User When is empty Name Then return EmptyValueException`() {
        val emptyName = ""
        val dataBuilder = UserDataBuilder().withName(name = emptyName)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation of the User When is empty Email Then return EmptyValueException`() {
        val emptyEmail = ""
        val dataBuilder = UserDataBuilder().withEmail(email = emptyEmail)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation of the User When is bad Email Then return BadEmailException`() {
        val badEmail = "badEmail"
        val dataBuilder = UserDataBuilder().withEmail(email = badEmail)
        try {
            dataBuilder.build()
            fail("Expected ${BadEmailException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is BadEmailException)
        }
    }

    @Test
    fun `Given the creation of the User When is empty Phone Then return EmptyValueException`() {
        val emptyPhone = ""
        val dataBuilder = UserDataBuilder().withPhone(phone = emptyPhone)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation of a the User When is correct field Then return Correct Object`() {
        val name = "Ceiba"
        val email = "caiba@ceiba.com"
        val phone = "3003003030"
        val user = UserDataBuilder()
            .withName(name)
            .withEmail(email)
            .withPhone(phone)
            .build()
        assertEquals(name, user.name)
        assertEquals(email, user.email)
        assertEquals(phone, user.phone)
    }
}