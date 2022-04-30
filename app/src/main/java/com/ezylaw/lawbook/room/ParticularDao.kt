package com.ezylaw.lawbook.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ezylaw.lawbook.model.Particular
import kotlinx.coroutines.flow.Flow

@Dao
interface ParticularDao {

    @Query("SELECT * FROM Particular")
    fun getPracticeList(): Flow<MutableList<Particular>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPracticeArea(particular: Particular)

    //@Update
    //suspend fun updateUser(practiceArea: Particular)

    //@Delete
    //suspend fun deleteUser(practiceArea: Particular)

}