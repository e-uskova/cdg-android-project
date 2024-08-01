package com.example.cdg_android_project

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchesRepository {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMatch(matchEntity: MatchEntity)

    @Delete
    fun deleteMatch(matchEntity: MatchEntity)

    @Update
    fun updateMatch(matchEntity: MatchEntity)

    @Query("SELECT * from $MATCHES_TABLE")
    fun getAllMatches(): Flow<List<MatchEntity>>

    companion object {
        const val MATCHES_TABLE = "matches_table"
    }
}
