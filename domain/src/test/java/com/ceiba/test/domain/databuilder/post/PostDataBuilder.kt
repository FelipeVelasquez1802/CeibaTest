package com.ceiba.test.domain.databuilder.post

import com.ceiba.test.domain.post.model.Post

class PostDataBuilder {
    private var id = 1
    private var title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
    private var body = """
        quia et suscipit
        suscipit recusandae consequuntur expedita et cum
        reprehenderit molestiae ut ut quas totam
        nostrum rerum est autem sunt rem eveniet architecto
    """.trimIndent()

    fun withId(id: Int): PostDataBuilder = this.apply { this.id = id }

    fun withTitle(title: String): PostDataBuilder = this.apply { this.title = title }

    fun withBody(body: String): PostDataBuilder = this.apply { this.body = body }

    fun build(): Post = Post(id, title, body)
}