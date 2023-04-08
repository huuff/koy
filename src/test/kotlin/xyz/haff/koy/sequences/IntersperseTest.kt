package xyz.haff.koy.sequences

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import xyz.haff.koy.sequences.intersperse

class IntersperseTest : FunSpec({

    test("intersperse") {
        // ARRANGE
        val sequence = sequenceOf("1", "2", "3")

        // ACT
        val interspersed = sequence.intersperse(",").toList()

        // ARRANGE
        interspersed shouldBe listOf("1", ",", "2", ",", "3")
    }
})
