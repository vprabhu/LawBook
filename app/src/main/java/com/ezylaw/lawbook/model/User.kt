package com.ezylaw.lawbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserDetails")
data class User(
    @PrimaryKey @ColumnInfo(name = "userId") val userId: Long,
    @ColumnInfo(name = "pwd") val pwd: String,
    @ColumnInfo(name = "first") val first: String,
    @ColumnInfo(name = "last") val last: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "dob") val dob: String,  //Cal
    @ColumnInfo(name = "gender") val gender: String, //
    @ColumnInfo(name = "totalExpYear") val expYear: Int,
    @ColumnInfo(name = "degree") val degree: String, //Multi selection
    @ColumnInfo(name = "barRegNo") val barRegNo: String,
    @ColumnInfo(name = "barName") val barName: String

)
