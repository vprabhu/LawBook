package com.ezylaw.lawbook.room

import androidx.annotation.WorkerThread
import com.ezylaw.lawbook.model.Particular
import kotlinx.coroutines.flow.Flow

class PracticeRepository(private val practiceAreaDao: PracticeAreaDao) {

    val getAllUserList: Flow<MutableList<Particular>> = practiceAreaDao.getPracticeList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertUser(particular: Particular) {
        practiceAreaDao.insertPracticeArea(particular)
    }


}