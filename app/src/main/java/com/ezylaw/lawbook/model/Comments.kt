package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Comments")
data class Comments(
    @PrimaryKey@ColumnInfo(name = "commentId") val commentId: String, //Auto
    @ColumnInfo(name = "caseId") val caseId: String,
    @ColumnInfo(name = "writerId") val writerId: String,
    @ColumnInfo(name = "commentTime") val commentTime: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "links") val links: String,
)
