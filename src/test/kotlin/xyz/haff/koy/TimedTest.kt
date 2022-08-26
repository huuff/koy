package xyz.haff.koy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.time.Clock
import kotlin.time.Duration.Companion.seconds

class TimedTest : FunSpec({

    test("in raw millis") {
        // ARRANGE
        val clock = mockk<Clock> {
            every { millis() } returns 0 andThen 100
        }

        // ACT
        val (response, elapsedMilliseconds) = timed(clock) { "response" }

        // ASSERT
        response shouldBe "response"
        elapsedMilliseconds shouldBe 100
    }

    test("in seconds") {
        // ARRANGE
        val clock = mockk<Clock> {
            every { millis() } returns 0 andThen 12380
        }

        // ACT
        val timedResult = timed(clock) { "response" }

        // ASSERT
        timedResult.result shouldBe "response"
        timedResult.elapsedSeconds shouldBe 12.38
    }

    test("in duration") {
        // ARRANGE
        val clock = mockk<Clock> {
            every { millis() } returns 0 andThen 12380
        }

        // ACT
        val timedResult = timed(clock) { "response" }

        // ASSERT
        timedResult.result shouldBe "response"
        timedResult.duration shouldBe 12.38.seconds
    }

})
