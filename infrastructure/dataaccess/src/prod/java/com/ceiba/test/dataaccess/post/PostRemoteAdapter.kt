package com.ceiba.test.dataaccess.post

import com.ceiba.test.dataaccess.common.api.ConfigApi
import com.ceiba.test.dataaccess.post.api.PostApi
import com.ceiba.test.dataaccess.post.dto.PostDto

internal class PostRemoteAdapter {
    private val api = ConfigApi.getApi(PostApi::class.java)
    fun getPostsBy(userId: Int): List<PostDto> {
        val postsDtoCall = api.getPostsBy(userId)
        val postsDtoResponse = postsDtoCall.execute()
        return postsDtoResponse.body().orEmpty()
    }
}