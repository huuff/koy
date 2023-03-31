package xyz.haff.koy.collections

// TODO: I could add others, like for Set

operator fun <T, R> List<T>.times(other: List<R>): List<Pair<T, R>> {
    val result = mutableListOf<Pair<T, R>>()

    for (elemInThis in this) {
        for (elemInOther in other) {
            result += elemInThis to elemInOther
        }
    }

    return result
}