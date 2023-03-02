package xyz.haff.koy.javatime

import xyz.haff.koy.javatime.LocalDateProgression
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime

val Int.days: Duration get() = Duration.ofDays(this.toLong())
val Int.hours: Duration get() = Duration.ofHours(this.toLong())
val Int.minutes: Duration get() = Duration.ofMinutes(this.toLong())
val Int.seconds: Duration get() = Duration.ofSeconds(this.toLong())
val Int.millis: Duration get() = Duration.ofMillis(this.toLong())

val String.asDate: LocalDate get() = LocalDate.parse(this)
val String.asTime: LocalTime get() = LocalTime.parse(this)
val String.asDateTime: LocalDateTime get() = LocalDateTime.parse(this)

val String.asOffsetDateTime: OffsetDateTime get() = OffsetDateTime.parse(this)

operator fun LocalDate.rangeTo(endInclusive: LocalDate) = LocalDateProgression(this, endInclusive)