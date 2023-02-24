package com.ceiba.test.dataaccess.post.mapper

import com.ceiba.test.dataaccess.post.database.entity.PostEntity
import com.ceiba.test.dataaccess.post.dto.PostDto
import com.ceiba.test.domain.post.model.Post

internal object PostMapper {
    private fun fromDtoToDomain(dto: PostDto): Post = Post(dto.id, dto.userId, dto.title, dto.body)

    fun fromListDtoToListDomain(listDto: List<PostDto>): List<Post> =
        listDto.map { fromDtoToDomain(it) }

    private fun fromEntityToDomain(entity: PostEntity): Post =
        Post(entity.id, entity.userId, entity.title, entity.body)

    fun fromListEntityToListDomain(listEntity: List<PostEntity>): List<Post> =
        listEntity.map { fromEntityToDomain(it) }

    private fun fromDtoToEntity(dto: PostDto): PostEntity =
        PostEntity(dto.id, dto.userId, dto.title, dto.body)

    fun fromListDtoToListEntity(listDto: List<PostDto>): List<PostEntity> =
        listDto.map { fromDtoToEntity(it) }
}