package com.ezylaw.lawbook.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithCasesClient(
    @Embedded val userId: Long,
    @Relation(
        parentColumn = "userId",
        entityColumn = "clientId"
    )
    val cases: List<Cases>
)
