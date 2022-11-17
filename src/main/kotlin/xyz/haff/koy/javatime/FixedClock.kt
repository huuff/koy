package xyz.haff.koy.javatime

import java.time.Clock
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

fun fixedClock(at: LocalDateTime): Clock {
    val zoneId = ZoneId.systemDefault()

    return Clock.fixed(at.atZone(zoneId).toInstant(), zoneId)
}

fun fixedClock(at: LocalDate): Clock = fixedClock(at.atStartOfDay())