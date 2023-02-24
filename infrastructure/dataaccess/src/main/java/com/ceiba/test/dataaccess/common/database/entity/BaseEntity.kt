package com.ceiba.test.dataaccess.common.database.entity

import androidx.room.ColumnInfo
import java.util.Date

internal const val LAST_UPDATE_KEY = "last_update"
internal abstract  class BaseEntity(
    @ColumnInfo(name = LAST_UPDATE_KEY) var lastUpdate: Long = Date().time
)