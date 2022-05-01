package com.ezylaw.lawbook.model

import androidx.room.Embedded
import androidx.room.Relation

data class LawyerWithCases(
    @Embedded val userId: String,
    @Relation(
        parentColumn = "userId",
        entityColumn = "lawyerId"
    )
    val cases: List<Cases>
)
