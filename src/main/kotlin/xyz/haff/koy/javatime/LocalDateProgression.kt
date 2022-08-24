package xyz.haff.koy.javatime

import java.time.LocalDate

class LocalDateProgression(
    override val start: LocalDate,
    override val endInclusive: LocalDate,
    private val stepDays: Long = 1
): Iterable<LocalDate>, ClosedRange<LocalDate> {
    override fun iterator(): Iterator<LocalDate> = LocalDateIterator(start, endInclusive, stepDays)

    infix fun step(stepDays: Long) = LocalDateProgression(start, endInclusive, stepDays)
}