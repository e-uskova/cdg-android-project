package com.example.cdg_android_project

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    @SerializedName("MatchNumber")
    var matchNumber: Int,
    @SerializedName("RoundNumber")
    var roundNumber: Int,
    @SerializedName("DateUtc")
    var dateUtc: String,
    @SerializedName("Location")
    var location: String,
    @SerializedName("HomeTeam")
    var homeTeam: String,
    @SerializedName("AwayTeam")
    var awayTeam: String,
    @SerializedName("Group")
    var group: String?,
    @SerializedName("HomeTeamScore")
    var homeTeamScore: Int,
    @SerializedName("AwayTeamScore")
    var awayTeamScore: Int
) : Parcelable {
    companion object {
        fun MatchEntity.toMatch(): Match = Match(
            matchNumber = this.matchNumber,
            roundNumber = this.roundNumber,
            dateUtc = this.dateUtc,
            location = this.location,
            homeTeam = this.homeTeam,
            awayTeam = this.awayTeam,
            group = this.group,
            homeTeamScore = this.homeTeamScore,
            awayTeamScore = this.awayTeamScore
        )

        fun Match.toMatchEntity(): MatchEntity = MatchEntity(
            matchNumber = this@toMatchEntity.matchNumber,
            roundNumber = this@toMatchEntity.roundNumber,
            dateUtc = this@toMatchEntity.dateUtc,
            location = this@toMatchEntity.location,
            homeTeam = this@toMatchEntity.homeTeam,
            awayTeam = this@toMatchEntity.awayTeam,
            group = this@toMatchEntity.group,
            homeTeamScore = this@toMatchEntity.homeTeamScore,
            awayTeamScore = this@toMatchEntity.awayTeamScore
        )
    }
}
