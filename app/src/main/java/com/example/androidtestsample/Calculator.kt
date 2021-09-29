package com.example.androidtestsample

import java.util.*

class Calculator {

    private val nums = createNumList()
    private val operators = listOf('+', '-', '/', '*')

    private val operatorCache = LinkedList<Char>()

    fun calculate(input: String): Int {
        var result = 0
        val inputArray = trimInput(input).toCharArray()
        if(inputArray.isEmpty()) return 0

        validate(inputArray)

        inputArray.forEach {
            result = resolveInputChar(result, it)
        }

        return result
    }

    private fun resolveInputChar(
        sum: Int,
        c: Char
    ): Int {
        if(nums.contains(c)) {
            val value = Character.getNumericValue(c)
            return operateNumbers(sum, value)
        }

        if(operators.contains(c)) {
            operatorCache.push(c)
        }

        return sum
    }

    private fun operateNumbers(
        sum: Int,
        value: Int
    ): Int {
        return if(operatorCache.isEmpty()) {
            value
        } else {
            val calc = createOperation(operatorCache.pop())
            calc(sum, value)
        }
    }

    private fun validate(inputArray: CharArray) {
        validateContainsZero(inputArray)
        validateLastOrFirstHasOperator(inputArray)
        validateOperatorContinuously(inputArray)
    }

    private fun validateContainsZero(inputArray: CharArray) {
        if(inputArray.contains('0')) {
            throw IllegalArgumentException()
        }
    }

    private fun validateLastOrFirstHasOperator(inputArray: CharArray) {
        if(operators.contains(inputArray.first())) {
            throw IllegalArgumentException()
        }
        if(operators.contains(inputArray.last())) {
            throw IllegalArgumentException()
        }
    }

    private fun validateOperatorContinuously(inputArray: CharArray) {
        var count = 0
        inputArray.forEach {
            if(operators.contains(it)) {
                count++
            } else {
                count = 0
            }

            if(count > 1) {
                throw IllegalArgumentException()
            }
        }
    }

    private fun trimInput(input: String): String {
        return input.trim().replace(" ", "")
    }

    private fun createOperation(operator: Char): (Int, Int) -> Int {
        return when(operator) {
            '-' -> { a: Int, b: Int -> a - b }
            '+' -> { a: Int, b: Int -> a + b }
            '/' -> { a: Int, b: Int -> a / b }
            '*' -> { a: Int, b: Int -> a * b }
            else -> throw IllegalArgumentException()
        }
    }

    private fun createNumList() =
        generateSequence(0) { it + 1 }.take(10).map { it.digitToChar() }.toList()
}