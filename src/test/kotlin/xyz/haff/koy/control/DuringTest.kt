package xyz.haff.koy.control

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlin.time.Duration.Companion.milliseconds

class DuringTest : FunSpec({

    // TODO: Use kotest extension for mocking System.currentTimeMillis (and assert something)
    test("during") {
        during(10.milliseconds) {
            println(System.currentTimeMillis())
        }
    }
})
