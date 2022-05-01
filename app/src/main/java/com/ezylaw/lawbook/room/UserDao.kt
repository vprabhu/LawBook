package com.ezylaw.lawbook.room

import androidx.room.*
import com.ezylaw.lawbook.model.User
import com.ezylaw.lawbook.model.UserWithAddress
import com.ezylaw.lawbook.model.LawyerWithCases
import com.ezylaw.lawbook.model.ClientWithCases
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserDetails")
    fun getUsers(): Flow<MutableList<User>> //Flow to observer db changes in real time

    @Query("SELECT * FROM UserDetails WHERE userId = :userId AND pwd = :pwd LIMIT 1")
    fun loginUsers(userId: Long, pwd: String): User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Transaction
    @Query("SELECT * FROM UserDetails WHERE userId = :userId")
    suspend fun getUserWithAddress(userId: String): List<UserWithAddress>

    @Transaction
    @Query("SELECT * FROM UserDetails WHERE userId = :userId")
    suspend fun getUserWithCasesClient(userId: String): List<LawyerWithCases>

    @Transaction
    @Query("SELECT * FROM UserDetails WHERE userId = :userId")
    suspend fun getUserWithCasesLawyer(userId: String): List<ClientWithCases>

}