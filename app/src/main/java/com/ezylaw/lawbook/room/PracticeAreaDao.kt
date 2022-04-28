package com.ezylaw.lawbook.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ezylaw.lawbook.model.PracticeArea
import kotlinx.coroutines.flow.Flow

@Dao
interface PracticeAreaDao {

    @Query("SELECT * FROM PracticeArea")
    fun getPracticeList(): Flow<MutableList<PracticeArea>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPracticeArea(practiceArea: PracticeArea)

    //@Update
    //suspend fun updateUser(practiceArea: PracticeArea)

    //@Delete
    //suspend fun deleteUser(practiceArea: PracticeArea)

}