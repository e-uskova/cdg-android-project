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
) : Parcelable
