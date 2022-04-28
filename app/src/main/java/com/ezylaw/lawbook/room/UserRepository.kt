package com.ezylaw.lawbook.room

import androidx.annotation.WorkerThread
import com.ezylaw.lawbook.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val getAllUserList: Flow<MutableList<User>> = userDao.getUsers()

     fun loginUsers(userId: Long, pwd: String): User {
        return userDao.loginUsers(userId, pwd)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

}