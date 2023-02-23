package com.ceiba.test.domain.user.model

import com.ceiba.test.domain.exception.BadEmailException
import com.ceiba.test.domain.exception.BadIdException
import com.ceiba.test.domain.exception.EmptyValueException

class User(val id: Int, val name: String, val email: String, val phone: String) {
    init {
        validations()
    }

    private fun validations() {
        validateId()
        validateName()
        validateEmail()
        validatePhone()
    }

    private fun validateId() {
        if (id <= 0) {
            throw BadIdException()
        }
    }

    private fun validateName() {
        if (name.isEmpty()) {
            throw EmptyValueException()
        }
    }

    private fun validateEmail() {
        validateIsEmptyEmail()
        validateBadEmail()
    }

    private fun validateIsEmptyEmail() {
        if (email.isEmpty()) {
            throw EmptyValueException()
        }
    }

    private fun validateBadEmail() {
        val emailRegex = Regex("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}\$")
        if (emailRegex.matches(email).not()) {
            throw BadEmailException()
        }
    }

    private fun validatePhone() {
        if (phone.isEmpty()) {
            throw EmptyValueException()
        }
    }
}