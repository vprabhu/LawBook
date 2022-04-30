package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Address")
data class Address(
    //Foriegn key userId
    @ColumnInfo(name = "addType") val addType: String, //From meta list
    @ColumnInfo(name = "houseNo") val houseNo: String,
    @ColumnInfo(name = "street") val street: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "pin") val pin: String,
    @ColumnInfo(name = "status") val status: String //From meta list open close coming soon
)
