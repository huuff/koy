package xyz.haff.koy.collections

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class IntersperseTest : FunSpec({

    test("intersperse") {
        listOf("1", "2", "3").intersperse(",") shouldBe listOf(
            "1",
            ",",
            "2",
            ",",
            "3",
        )
    }
})
