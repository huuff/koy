package xyz.haff.koy.collections

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class CartesianProductExtensionsTest : FunSpec({

    test("correctly does the cartesian product") {
        // ARRANGE
        val firstList = listOf("one", "two")
        val secondList = listOf(1, 2, 3)

        // ACT
        val cartesianProduct = firstList * secondList

        // ASSERT
        cartesianProduct shouldContainExactlyInAnyOrder listOf(
            "one" to 1,
            "one" to 2,
            "one" to 3,
            "two" to 1,
            "two" to 2,
            "two" to 3
        )
    }

})
