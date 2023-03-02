package xyz.haff.koy.strings

private val WORD = Regex("""\w+""")
private val NUMBER = Regex("""\d+""")

val String.words get() = WORD.findAll(this).map { it.value }.toList()

operator fun String.minus(other: String) = this.replace(other, "")


// TODO: This as a property like firstInteger?
fun String.withoutNumbers() = this.replace(NUMBER, "")

/**
 * Only returns any integer that's contained in the string, without any other characters
 */
val String.firstInteger get() = NUMBER.find(this)?.value?.toInt()