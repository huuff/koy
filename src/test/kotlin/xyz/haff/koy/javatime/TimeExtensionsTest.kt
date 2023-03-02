package xyz.haff.koy.javatime

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.time.*

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

        test("as offset-date-time") {
            "2021-01-09T00:00+01:00".asOffsetDateTime shouldBe OffsetDateTime.of(
                LocalDateTime.of(
                    LocalDate.of(2021, 1, 9),
                    LocalTime.of(0, 0, 0),
                ),
                ZoneOffset.ofHours(1)
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
