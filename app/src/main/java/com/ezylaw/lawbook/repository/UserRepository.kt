package com.ezylaw.lawbook.repository

import androidx.annotation.WorkerThread
import com.ezylaw.lawbook.dao.UsersDao
import com.ezylaw.lawbook.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val usersDao: UsersDao) {

    val allUsers: Flow<MutableList<User>> = usersDao.getUsers()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User) {
        usersDao.insertUser(user)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(user: User) {
        usersDao.deleteUser(user)
    }

}