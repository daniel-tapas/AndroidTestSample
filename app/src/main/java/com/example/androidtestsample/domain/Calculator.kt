package com.example.androidtestsample.domain

class Calculator {
    fun calculate(input: String): Int {
        val expression = Expression(input)
        val list = expression.list

        var result = list[0].toInt()

        for (i in 1 until list.size step 2) {
            val operator = Operator.valueOf(code = list[i])
            if (operator != null) {
                result = operator.run(result, list[i+1].toInt())
            }
        }

        return result
    }
}