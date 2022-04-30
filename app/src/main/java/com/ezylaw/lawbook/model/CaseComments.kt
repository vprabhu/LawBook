package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CaseComments")
data class CaseComments(
    @PrimaryKey@ColumnInfo(name = "commentId") val addType: String, //Auto
    @ColumnInfo(name = "caseId") val houseNo: String,
    @ColumnInfo(name = "writerId") val street: String,
    @ColumnInfo(name = "commentTime") val caseTypeId: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "links") val links: String,
)
