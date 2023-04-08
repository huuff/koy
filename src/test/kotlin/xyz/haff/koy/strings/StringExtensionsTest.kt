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

    test("minus") {
        "test*string" - "test" shouldBe "*string"
    }

    test("withoutNumbers") {
        "34TEST567".withoutNumbers shouldBe "TEST"
    }

    test("firstInteger") {
        "34TEST".firstInteger shouldBe 34
    }

    test("splitByParts") {
        val (prefix, rest) = "test/string/split/parts".splitByParts("/", 2)

        prefix shouldBe "test/string"
        rest shouldBe "split/parts"
    }
})
