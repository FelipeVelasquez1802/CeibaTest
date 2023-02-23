package com.ceiba.test.dataaccess.post.api

import com.ceiba.test.dataaccess.post.dto.PostDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PostApi {
    @GET("/posts")
    fun getPostsBy(@Query("userId") userId: Int): Call<List<PostDto>>
}