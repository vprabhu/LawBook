package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Address")
data class Address(
    @PrimaryKey(autoGenerate = true) val id: Long,  // Auto generated id
    @ColumnInfo(name = "userId") val userId: String, //from User
    @ColumnInfo(name = "addType") val addType: String, //From meta list
    @ColumnInfo(name = "houseNo") val houseNo: String,
    @ColumnInfo(name = "street") val street: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "pin") val pin: String,
    @ColumnInfo(name = "status") val status: String //From meta list open close coming soon
) {
    constructor(addType: String, userId: String, houseNo: String, street: String, city: String, pin: String, status: String)
            : this(0, addType,userId , houseNo, street, city, pin, status)
}
