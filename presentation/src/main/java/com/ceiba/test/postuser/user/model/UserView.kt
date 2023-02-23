package com.ceiba.test.postuser.user.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class UserView(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
) : Parcelable