package com.ceiba.test.dataaccess.post.mapper

import com.ceiba.test.dataaccess.post.dto.PostDto
import com.ceiba.test.domain.post.model.Post

internal object PostMapper {
    private fun fromDtoToDomain(dto: PostDto): Post = Post(dto.id, dto.title, dto.body)

    fun fromListDtoToListDomain(listDto: List<PostDto>): List<Post> =
        listDto.map { fromDtoToDomain(it) }
}