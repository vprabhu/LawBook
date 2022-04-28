package com.ezylaw.lawbook.room

import androidx.annotation.WorkerThread
import com.ezylaw.lawbook.model.PracticeArea
import kotlinx.coroutines.flow.Flow

class PracticeRepository(private val practiceAreaDao: PracticeAreaDao) {

    val getAllUserList: Flow<MutableList<PracticeArea>> = practiceAreaDao.getPracticeList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertUser(practiceArea: PracticeArea) {
        practiceAreaDao.insertPracticeArea(practiceArea)
    }


}