package xyz.haff.koy.control

import kotlin.time.Duration

inline fun during(duration: Duration, block: () -> Unit) {
    val endTime = System.currentTimeMillis() + duration.inWholeMilliseconds

    while (System.currentTimeMillis() < endTime) {
        block()
    }
}