package xyz.haff.koy.javatime

import java.time.LocalDate

class LocalDateIterator(
    private val start: LocalDate,
    private val endInclusive: LocalDate,
    private val stepDays: Long,
): Iterator<LocalDate> {
    private var current = start

    override fun hasNext(): Boolean = current <= endInclusive

    override fun next(): LocalDate = current.also {
        current = current.plusDays(stepDays)
    }
}