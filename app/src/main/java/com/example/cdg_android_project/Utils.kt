package com.example.cdg_android_project

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

private fun dateUtcToLocalDate(dateUtc: String) = LocalDateTime
    .parse(
        dateUtc,
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss'Z'")
    )
    .atZone(ZoneId.of("UTC"))

private fun weekdayFromDateUtc(dateUtc: String) = dateUtcToLocalDate(dateUtc)
    .dayOfWeek
    .getDisplayName(
        TextStyle.FULL,
        Locale("en", "EN")
    )

private val formatter = DateTimeFormatter
    .ofPattern(
        "dd MMMM yyyy - HH:mm",
        Locale("en", "EN")
    )
    .withZone(ZoneId.systemDefault())

fun dateUtcFormatted(dateUtc: String): String = dateUtcToLocalDate(dateUtc).format(formatter)

fun dateUtcFormattedWithWeekday(dateUtc: String) = "${weekdayFromDateUtc(dateUtc)}, ${dateUtcFormatted(dateUtc)}"
