package com.example.cdg_android_project

import kotlin.math.abs

data class FootballMatch (
    var firstCommandGoals: Int = 0,
    var secondCommandGoals: Int = 0
) {
    fun setGoalsNum(
        firstCommandGoals: Int,
        secondCommandGoals: Int
    ) {
        this.firstCommandGoals = firstCommandGoals
        this.secondCommandGoals = secondCommandGoals
    }
}

fun printMatches(info: String, matches: Collection<FootballMatch>) {
    println(info)
    for (match in matches) {
        println("${match.firstCommandGoals} - ${match.secondCommandGoals}")
    }
    println()
}

fun runTask1() {
    //  create array of matches using random fun
    val matches = MutableList(10, fun(_): FootballMatch{
        val match = FootballMatch()
        match.setGoalsNum((0..5).random(), (0..5).random())
        return match
    })

    printMatches("Все матчи", matches)

    // delete matches where num of goals is equal
    matches.removeIf { it.firstCommandGoals == it.secondCommandGoals }

    printMatches("Матчи с неравным счетом", matches)

    // create set of matches, where max diff in goals
    val maxDiffMatchesSet = mutableSetOf<FootballMatch>()
    var maxDiff = 0
    for (match in matches) {
        val matchDiff = abs(match.firstCommandGoals - match.secondCommandGoals)
        if (matchDiff > maxDiff) {
            maxDiff = matchDiff
            maxDiffMatchesSet.clear()
            maxDiffMatchesSet.add(match)
        } else if (matchDiff == maxDiff) {
            maxDiffMatchesSet.add(match)
        }
    }

    printMatches("Матчи с максимальной разницей голов", maxDiffMatchesSet)
}
