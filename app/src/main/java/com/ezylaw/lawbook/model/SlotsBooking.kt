package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SlotsBooking")
data class SlotsBooking(
    @PrimaryKey@ColumnInfo(name = "slotId") val slotId: String,
    @ColumnInfo(name = "caseId") val caseId: String,
    @ColumnInfo(name = "requesterId") val requesterId: String,
    @ColumnInfo(name = "accepted") val accepted: String,
    @ColumnInfo(name = "startScheduleTime") val startScheduleTime: String, // Some calender API
    @ColumnInfo(name = "endScheduleTime") val endScheduleTime: String,
    @ColumnInfo(name = "startActualTime") val startActualTime: String,
    @ColumnInfo(name = "endActualTime") val endActualTime: String,
    @ColumnInfo(name = "slotMode") val status: String //From meta phone , video , person
)
