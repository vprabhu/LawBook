package com.ezylaw.lawbook.room

import androidx.annotation.WorkerThread
import com.ezylaw.lawbook.model.Particular
import kotlinx.coroutines.flow.Flow

class ParticularRepository(private val particularDao: ParticularDao) {

    val getAllUserList: Flow<MutableList<Particular>> = particularDao.getPracticeList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertUser(particular: Particular) {
        particularDao.insertPracticeArea(particular)
    }


}