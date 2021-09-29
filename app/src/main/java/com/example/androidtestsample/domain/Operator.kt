package com.example.androidtestsample.domain

enum class Operator(
    val code: String,
    val run: (a: Int, b: Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    TIMES("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),
    ;

    companion object {
        fun valueOf(code: String): Operator? {
            return when(code) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> TIMES
                "/" -> DIVIDE
                else -> null
            }
        }
    }
}