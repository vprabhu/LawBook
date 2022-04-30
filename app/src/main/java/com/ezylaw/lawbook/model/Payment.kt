package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Payment")
data class Payment(
    @PrimaryKey@ColumnInfo(name = "paymentId") val paymentId: String,  //Some Unique Time appender
    @ColumnInfo(name = "caseRefId") val caseRefId: String,
    @ColumnInfo(name = "payerId") val payerUserId: String,
    @ColumnInfo(name = "receiverId") val receiverUserId: String,
    @ColumnInfo(name = "transactionNumber") val transactionNumber: String,
    @ColumnInfo(name = "paymentMode") val paymentMode: String,
    @ColumnInfo(name = "amount") val amount: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "settlement") val settlement: String,
    @ColumnInfo(name = "paymentRequestTime") val paymentRequestTime: String,
    @ColumnInfo(name = "paymentApprovedTime") val paymentApprovedTime: String,
    )
