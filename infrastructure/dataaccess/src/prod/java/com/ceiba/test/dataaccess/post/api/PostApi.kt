package com.ceiba.test.dataaccess.post.api

import com.ceiba.test.dataaccess.post.dto.PostDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val POST_PATH = "/posts"
private const val USER_ID_KEY = "userId"

internal interface PostApi {
    @GET(POST_PATH)
    fun getPostsBy(@Query(USER_ID_KEY) userId: Int): Call<List<PostDto>>
}