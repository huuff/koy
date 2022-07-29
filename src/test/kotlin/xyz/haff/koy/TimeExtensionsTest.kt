package xyz.haff.koy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class TimeExtensionsTest : FunSpec({

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
})
