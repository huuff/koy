package xyz.haff.koy.strings

private val WORD = Regex("""\w+""")
private val NUMBER = Regex("""\d+""")

val String.words get() = WORD.findAll(this).map { it.value }.toList()

operator fun String.minus(other: String) = this.replace(other, "")


val String.withoutNumbers get() = this.replace(NUMBER, "")

/**
 * Only returns any integer that's contained in the string, without any other characters
 */
val String.firstInteger get() = NUMBER.find(this)?.value?.toInt()

/**
 * Using a **delimiter**, splits the string into one that has **n** parts and one that has the rest, removing the **delimiter**
 * that separates them.
 *
 * It's not particularly efficient.
 *
 * Example: "test/string/split".splitByParts("/", 2) gives Pair("test/string", "split")
 */
fun String.splitByParts(delimiter: String, n: Int): Pair<String, String> {
    val allParts = this.split(delimiter)

    return Pair(
        allParts.slice(0 until n).joinToString(separator = delimiter),
        allParts.slice(n until allParts.size).joinToString(separator = delimiter)
    )
}