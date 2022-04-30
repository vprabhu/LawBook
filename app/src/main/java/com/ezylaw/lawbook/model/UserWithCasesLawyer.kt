package com.ezylaw.lawbook.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithCasesLawyer(
    @Embedded val userId: Long,
    @Relation(
        parentColumn = "userId",
        entityColumn = "lawyerId"
    )
    val cases: List<Cases>
)
