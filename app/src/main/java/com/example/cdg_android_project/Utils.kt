package com.example.cdg_android_project

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


fun dateUtcFormatted(date: String): String {
    val localDate = LocalDateTime
        .parse(
            date,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss'Z'")
        )
        .atZone(ZoneId.of("UTC"))
    val dayOfWeek = localDate.dayOfWeek.getDisplayName(
        TextStyle.FULL,
        Locale("en", "EN")
    )
    val formatter = DateTimeFormatter
        .ofPattern(
            "dd MMMM yyyy - HH:mm",
            Locale("en", "EN")
        )
        .withZone(ZoneId.systemDefault())

    return "$dayOfWeek, ${localDate.format(formatter)}"
}
