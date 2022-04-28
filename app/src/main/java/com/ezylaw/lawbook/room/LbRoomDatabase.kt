package com.ezylaw.lawbook.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ezylaw.lawbook.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
) //exportSchema = false true In case of Migration
public abstract class LbRoomDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile    //This will guarantee visibility of changes for other threads as soon as the value is changed
        private var INSTANCE: LbRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LbRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LbRoomDatabase::class.java,
                    "lawbook_db"
                ).addCallback(LawBookCallback(scope))
                    .build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

    private class LawBookCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
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