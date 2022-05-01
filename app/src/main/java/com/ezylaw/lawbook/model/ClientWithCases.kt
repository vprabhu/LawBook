package com.ezylaw.lawbook.model

import androidx.room.Embedded
import androidx.room.Relation

data class ClientWithCases(
    @Embedded val userId: String,
    @Relation(
        parentColumn = "userId",
        entityColumn = "clientId"
    )
    val cases: List<Cases>
)
