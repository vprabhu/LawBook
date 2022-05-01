package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Particular")
data class Particular(
    //Foriegn key userId + titleId = Primary key
    @PrimaryKey @ColumnInfo(name = "typeId") val typeId: Long, //From meta list
    @ColumnInfo(name = "userId") val userId: String,
    @ColumnInfo(name = "expYrField") val expYrField: Int,
    @ColumnInfo(name = "noOfCases") val noOfCases: String,
    @ColumnInfo(name = "feePhone") val feePhone: Int,
    @ColumnInfo(name = "feeVideo") val feeVideo: Int,
    @ColumnInfo(name = "feeInPerson") val feeInPerson: Int,
    @ColumnInfo(name = "ownDescription") val ownDescription: String,
    @ColumnInfo(name = "visible") val status: Boolean //From meta list yes no
)
