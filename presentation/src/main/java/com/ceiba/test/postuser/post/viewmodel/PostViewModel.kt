package com.ceiba.test.postuser.post.viewmodel

import androidx.compose.runtime.mutableStateListOf
import com.ceiba.test.domain.post.model.Post
import com.ceiba.test.domain.post.service.PostService
import com.ceiba.test.postuser.common.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class PostViewModel @Inject constructor() : BaseViewModel() {
    @Inject
    protected lateinit var postService: PostService

    val post: MutableList<Post> = mutableStateListOf()

    fun executeGetPostBy(userId: Int) {
        showLoading.value = true
        CoroutineScope(IO).launch {
            val result = postService.consultPostsBy(userId)
            post.clear()
            post.addAll(result)
            showLoading.value = false
        }
    }
}