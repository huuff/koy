package xyz.haff.koy.sequences

fun <T> Sequence<T>.intersperse(separator: T): Sequence<T> = sequence {
    val iterator = this@intersperse.iterator()

    // Yield the first element without a separator
    if (iterator.hasNext()) {
        yield(iterator.next())
    }

    // Yield the separator to the previous element, and then the element itself
    while (iterator.hasNext()) {
        yield(separator)
        yield(iterator.next())
    }
}
