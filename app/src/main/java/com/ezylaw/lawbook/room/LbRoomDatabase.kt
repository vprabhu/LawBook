package com.ezylaw.lawbook.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ezylaw.lawbook.model.*
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [
        Address::class,
        Cases::class,
        Comments::class,
        Particular::class,
        Payment::class,
        Slots::class,
        User::class
    ],
    version = 1,
    exportSchema = false
) //exportSchema = false true In case of Migration
public abstract class LbRoomDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun practiceAreaDao(): ParticularDao

    companion object {

        @Volatile    //This will guarantee visibility of changes for other threads as soon as the value is changed
        private var INSTANCE: LbRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LbRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LbRoomDatabase::class.java,
                    "lawbook_db"
                ).build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

}