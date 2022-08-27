package xyz.haff.koy.strings

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringExtensionsTest : FunSpec({


    test("words") {
        // ARRANGE
        val string = "correct horse battery staple"

        // ACT
        val words = string.words

        // ASSERT
        words shouldBe listOf("correct", "horse", "battery", "staple")
    }
})
