package xyz.haff.koy.collections

inline fun <T, R> Pair<T, T>.map(f: (T) -> R): Pair<R, R> {
    return f(this.first) to f(this.second)
}