package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cases")
data class Cases(
    @PrimaryKey @ColumnInfo(name = "caseId") val caseId: String, //From meta list
    @ColumnInfo(name = "clientId") val clientId: String,
    @ColumnInfo(name = "lawyerId") val lawyerId: String,
    @ColumnInfo(name = "caseTypeId") val caseTypeId: String,
    @ColumnInfo(name = "caseStatus") val caseStatus: String, //closed
    @ColumnInfo(name = "paymentStatus") val paymentStatus: String,
    @ColumnInfo(name = "lawyerAccepted") val lawyerAccepted: String,
    @ColumnInfo(name = "registerTime") val paymentRequestTime: String,
    @ColumnInfo(name = "userCaseTitle") val userCaseTitle: String,
    @ColumnInfo(name = "userCaseTypeSelection") val userCaseTypeSelection: String,
    @ColumnInfo(name = "userCaseDescription") val userCaseDescription: String,
    @ColumnInfo(name = "serviceMode") val serviceMode: String, //phone, video, person
    @ColumnInfo(name = "userLinks") val userLinks: String,
    @ColumnInfo(name = "lawyerLinks") val lawyerLinks: String,

    )
