package xyz.haff.koy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BooleanExtensionsTest: FunSpec({

    context("to int") {
        test("correctly converts 0") {
            false.toInt() shouldBe 0
        }

        test("correctly converts 1") {
            true.toInt() shouldBe 1
        }
    }

    context("implies") {
        test("0 -> 0") {
            (false implies false) shouldBe true
        }

        test("0 -> 1") {
            (false implies true) shouldBe true
        }

        test("1 -> 0") {
            (true implies false) shouldBe false
        }

        test("1 -> 1") {
            (true implies true) shouldBe true
        }
    }
})