package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserDetails")
data class User(
    @PrimaryKey @ColumnInfo(name = "userId") val userId: Long,
    @ColumnInfo(name = "pwd") val pwd: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "age") val age: Int,
)
