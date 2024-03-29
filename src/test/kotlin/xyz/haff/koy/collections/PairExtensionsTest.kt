package xyz.haff.koy.collections

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PairExtensionsTest : FunSpec({

    test("map") {
        ("1" to "2").map { it.toInt() } shouldBe (1 to 2)
    }

    test("toPairOfNullables") {
        val pair: Pair<String, String>? = null
        val (first, second) = pair.toPairOfNullables()

        first shouldBe null
        second shouldBe null
    }
})
