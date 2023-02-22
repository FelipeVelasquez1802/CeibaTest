package com.ceiba.test.domain.user.model

import com.ceiba.test.domain.exception.BadEmailException
import com.ceiba.test.domain.exception.EmptyValueException

class User(val name: String, val email: String, val phone: String) {
    init {
        validations()
    }

    private fun validations() {
        validateName()
        validateEmail()
        validatePhone()
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