package com.example.cdg_android_project

data class FMatch(
    val matchNumber: Int,
    val roundNumber: Int,
    val dateUtc: String,
    val location: String,
    val homeTeam: String,
    val awayTeam: String,
    val group: String?,
    val homeTeamScore: Int,
    val awayTeamScore: Int
)

val mockMatch = FMatch(
    1,
    1,
    "2021-08-13 19:00:00Z",
    "Brentford Community Stadium",
    "Brentford",
    "Arsenal",
    "A",//null,//
    2,
    0
)

fun matchById(id :Int) : FMatch {
    // TODO get match info by id

    return FMatch(
        id,
        1,
        "2021-08-13 19:00:00Z",
        "Brentford Community Stadium",
        "Brentford",
        "Arsenal",
        null,//"A",//
        2,
        0
    )
}