package com.example.cdg_android_project

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MatchEntity::class], version = 1)
abstract class MatchesDatabase : RoomDatabase() {
    abstract fun matchesDao(): MatchDao

    companion object {
        private var INSTANCE: MatchesDatabase? = null
        fun createDatabase(context: Context): Boolean {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        MatchesDatabase::class.java,
                        "matches_database"
                    )
                        .build()
                    return true
                }
            }
            return false
        }
        fun getDatabase(): MatchesDatabase? = INSTANCE
    }
}
