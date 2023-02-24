package com.ceiba.test.dataaccess.common.database.entity

import androidx.room.ColumnInfo
import java.util.Date

internal abstract  class BaseEntity(
    @ColumnInfo(name = "last_update") var lastUpdate: Long = Date().time
)