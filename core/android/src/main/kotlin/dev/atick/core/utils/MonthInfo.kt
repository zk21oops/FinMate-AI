package dev.atick.core.utils

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

/**
 * Data class that represents information about a month.
 *
 * @param monthName The name of the month.
 * @param year The year of the month.
 * @param startDate The start date of the month in milliseconds.
 * @param endDate The end date of the month in milliseconds.
 */
data class MonthInfo(
    val monthName: String,
    val year: Int,
    val startDate: Long,
    val endDate: Long,
)

/**
 * Returns information about the month at the specified offset.
 *
 * @param monthOffset The offset of the month to get information about.
 * @return Information about the month at the specified offset.
 * Example usage:
 * ```
 * val monthInfo = getMonthInfoAt(1)
 * println("Month: ${monthInfo.monthName}, Year: ${monthInfo.year}")
 * ```
 */
fun getMonthInfoAt(monthOffset: Int = 0): MonthInfo {
    val offsetDate = Clock.System.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date.plus(monthOffset, DateTimeUnit.MONTH)

    val startOfMonth = LocalDateTime(
        year = offsetDate.year,
        month = offsetDate.month,
        day = 1,
        hour = 0,
        minute = 0,
        second = 0,
        nanosecond = 0,
    )

    val startOfMonthMillis = startOfMonth
        .toInstant(TimeZone.currentSystemDefault())
        .toEpochMilliseconds()

    val endOfMonthMillis = startOfMonth
        .date.plus(1, DateTimeUnit.MONTH)
        .atStartOfDayIn(TimeZone.currentSystemDefault())
        .toEpochMilliseconds()

    return MonthInfo(
        monthName = startOfMonth.month.name,
        year = startOfMonth.year,
        startDate = startOfMonthMillis,
        endDate = endOfMonthMillis,
    )
}
