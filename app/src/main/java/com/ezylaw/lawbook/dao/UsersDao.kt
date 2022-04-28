package com.ezylaw.lawbook.dao

import androidx.room.*
import com.ezylaw.lawbook.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {

    @Query("SELECT * FROM UserDetails")
    fun getUsers(): Flow<MutableList<User>> //Flow to observer db changes in real time

    @Query("SELECT * FROM UserDetails WHERE userId = :userId AND pwd = :pwd LIMIT 1")
    suspend fun logUsers(userId: Long, pwd: String): User

    @Query("UPDATE UserDetails SET age = age + 1 WHERE userId = :userId")
    suspend fun incrementUserAge(userId: Long)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

}