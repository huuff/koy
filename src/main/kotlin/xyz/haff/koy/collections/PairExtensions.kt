package xyz.haff.koy.collections

inline fun <T, R> Pair<T, T>.map(f: (T) -> R): Pair<R, R> {
    return f(this.first) to f(this.second)
}

/**
 * Allows for using decomposition with null pairs:
 *  * If the pair is not null, it just returns it.
 *  * Otherwise, it returns a pair of nulls.
 *
 *  Example:
 *  ```kotlin
 *  // This is impossible
 *  val pair: Pair<String, String>? = null
 *  val (first, second) = null
 *  // But now we can do this
 *  val (first, second) = null.toPairOfNullables()
 *  ```
 */
fun <T, R> Pair<T, R>?.toPairOfNullables(): Pair<T?, R?> {
    return this ?: (null to null)
}