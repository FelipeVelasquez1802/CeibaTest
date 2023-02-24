package com.ceiba.test.domain.post.model

import com.ceiba.test.domain.exception.BadIdException
import com.ceiba.test.domain.exception.EmptyValueException

class Post(val id: Int, val userId: Int, val title: String, val body: String) {
    init {
        validations()
    }

    private fun validations() {
        validateId()
        validateTitle()
        validateBody()
    }

    private fun validateId() {
        if (id <= 0) {
            throw BadIdException()
        }
    }

    private fun validateTitle() {
        if (title.isEmpty()) {
            throw EmptyValueException()
        }
    }

    private fun validateBody() {
        if (body.isEmpty()) {
            throw EmptyValueException()
        }
    }
}