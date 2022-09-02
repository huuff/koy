package xyz.haff.koy.strings

private val WORD = Regex("""\w+""")
val String.words get() = WORD.findAll(this).map { it.value }.toList()

operator fun String.minus(other: String) = this.replace(other, "")