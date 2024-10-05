package com.puc.cinefy.user.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbUser")
data class User (
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var name: String,
    @ColumnInfo(index = true)
    var email: String,
    var password: String
) {
}