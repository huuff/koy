package xyz.haff.koy

import java.time.Clock
import kotlin.time.Duration.Companion.milliseconds

// TODO: I think this is in the standard library and deprecated (measureTimeMillis)

// Using long for elapsed milliseconds in case we need to time some long-running function for longer than 290 million years
data class TimedResult<T>(val result: T, val elapsedMilliseconds: Long) {
    val elapsedSeconds get() = (elapsedMilliseconds.toDouble() / 1000)
    val duration get() = elapsedMilliseconds.milliseconds
}
inline fun <T> timed(clock: Clock = Clock.systemDefaultZone(), f: () -> T): TimedResult<T> {
    val startTime = clock.millis()
    val result = f()
    val endTime = clock.millis()
    return TimedResult(result, endTime - startTime)
}