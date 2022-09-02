package xyz.haff.koy

fun Boolean.toInt() = if (this) { 1 } else { 0 }

infix fun Boolean.implies(other: Boolean) = if (this) { other } else { true }

fun Boolean.ifTrue(value: String): String = if (this) { value } else { "" }