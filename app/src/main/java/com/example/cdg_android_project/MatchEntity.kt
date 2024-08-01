package com.example.cdg_android_project

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MatchesRepository.MATCHES_TABLE)
data class MatchEntity(
    @PrimaryKey(autoGenerate = false)
    val matchNumber: Int,
    val roundNumber: Int,
    val dateUtc: String,
    val location: String,
    val homeTeam: String,
    val awayTeam: String,
    val group: String?,
    val homeTeamScore: Int,
    val awayTeamScore: Int,
)
