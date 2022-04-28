package com.ezylaw.lawbook

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ezylaw.lawbook.dao.UsersDao
import com.ezylaw.lawbook.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
) //exportSchema = false true In case of Migration
public abstract class UserRoomDB : RoomDatabase() {

    abstract fun userDao(): UsersDao

    companion object {

        @Volatile    //This will guarantee visibility of changes for other threads as soon as the value is changed
        private var INSTANCE: UserRoomDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UserRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDB::class.java,
                    "lawbook_db"
                ).addCallback(UsersCallback(scope))
                    .build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

    private class UsersCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { userRoomDB ->
                scope.launch {
                    // if you want to populate database
                    // when RoomDatabase is created
                    // populate here
                    userRoomDB.userDao().insertUser(User(1, "abc123", "Admin", "9999999999", 25))
                }
            }
        }
    }
}