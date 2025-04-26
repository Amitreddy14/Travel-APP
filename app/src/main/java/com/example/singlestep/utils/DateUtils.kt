package com.example.singlestep.utils

import androidx.core.util.Pair
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

fun getSelectedDateRange(selection: Pair<Long, Long>): String {
    val utc = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    utc.timeInMillis = selection.first
    val startDateString = getDateString(utc)
    utc.timeInMillis = selection.second
    val endDateString = getDateString(utc)
    return "$startDateString - $endDateString"
}

