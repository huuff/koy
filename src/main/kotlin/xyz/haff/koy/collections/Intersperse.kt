package xyz.haff.koy.collections

fun <T> List<T>.intersperse(separator: T): List<T> = this.flatMapIndexed { index, it ->
    if (index != this.size -1) {
        sequenceOf(it, separator)
    } else {
        sequenceOf(it)
    }
}