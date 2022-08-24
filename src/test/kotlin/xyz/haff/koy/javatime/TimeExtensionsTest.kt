package xyz.haff.koy.javatime

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class TimeExtensionsTest : FunSpec({

    context("date literals") {
        test("as date") {
            "2022-07-29".asDate shouldBe LocalDate.of(2022, 7, 29)
        }

        test("as time") {
            "18:30:50".asTime shouldBe LocalTime.of(18, 30, 50)
        }

        test("as date-time") {
            "2022-07-29T18:30:50".asDateTime shouldBe LocalDateTime.of(
                LocalDate.of(2022, 7, 29),
                LocalTime.of(18, 30, 50)
            )
        }
    }

    test("date progression") {
        // ARRANGE
        val producedDates = mutableListOf<LocalDate>()

        // ACT
        for (date in "2022-01-01".asDate .. "2022-01-10".asDate step 2) {
            producedDates += date
        }

        // ASSERT
        producedDates shouldBe listOf(
            "2022-01-01".asDate,
            "2022-01-03".asDate,
            "2022-01-05".asDate,
            "2022-01-07".asDate,
            "2022-01-09".asDate
        )
    }
})
