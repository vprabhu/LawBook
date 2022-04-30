package com.ezylaw.lawbook.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithAddress(
    @Embedded val userId: Long,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val address: List<Address>
)