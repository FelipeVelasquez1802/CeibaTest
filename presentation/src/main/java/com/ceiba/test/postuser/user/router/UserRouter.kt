package com.ceiba.test.postuser.user.router

import android.content.Context
import android.content.Intent
import com.ceiba.test.domain.user.model.User
import com.ceiba.test.postuser.post.activity.PostActivity
import com.ceiba.test.postuser.user.mapper.UserMapper
import com.ceiba.test.postuser.user.model.KeyField

object UserRouter {
    fun goToPost(context: Context, user: User) {
        val intent = Intent(context, PostActivity::class.java)
        val userView = UserMapper.fromDomainToView(user)
        intent.putExtra(KeyField.NAME.name, userView)
        context.startActivity(intent)
    }
}