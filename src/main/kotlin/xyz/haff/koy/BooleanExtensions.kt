package xyz.haff.koy

fun Boolean.toInt() = if (this) { 1 } else { 0 }

infix fun Boolean.implies(other: Boolean) = if (this) { other } else { true }

/**
 * Produces the passed param only if the receiver is true, or the empty string otherwise.
 *
 * A shortcut for constructs like
 *
 * ```
 * println("Request sent ${if (addIdToLog) { "id: $id" } else { "" }}")
 * ```
 *
 * To make it
 *
 * ```
 * println("Request sent ${addIdToLog.ifTrue("id: $id"}")
 * ```
 */
fun Boolean.ifTrue(value: String): String = if (this) { value } else { "" }

/**
 * Produces the passed param only if the receiver is true, or null otherwise.
 *
 * A shortcut for constructs like
 *
 * ```
 * val result = if (boolean) {
 *  value
 * } else {
 *  null
 * }
 *
 * ```
 *
 * To make it
 *
 * ```
 * val result = boolean.ifTrue(value)
 * ```
 */
fun <T> Boolean.ifTrue(value: T): T? = if (this) { value } else { null }