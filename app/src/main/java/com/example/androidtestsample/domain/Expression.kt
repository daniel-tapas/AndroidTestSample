package com.example.androidtestsample.domain

class Expression(input: String) {

    val list: List<String>
        get() = operandList.toList()

    private var operandList = mutableListOf<String>()

    init {
        operandList.addAll(splitInput(input))
        validate()
    }

    private fun splitInput(input: String): List<String> {
        return input.trim().replace("\\s+".toRegex(), " ").split(" ")
    }

    private fun validate() {
        validateEmpty()
        validateContainsZero()
        validateLastOrFirstHasOperator()
        validateOperatorContinuously()
    }

    private fun validateEmpty() {
        if(operandList.isEmpty()) {
            throw IllegalArgumentException()
        }
    }

    private fun validateContainsZero() {
        if(operandList.contains("0")) {
            throw IllegalArgumentException()
        }
    }

    private fun validateLastOrFirstHasOperator() {
        if(Operator.valueOf(code = operandList.first()) != null) {
            throw IllegalArgumentException()
        }
        if(Operator.valueOf(code = operandList.last()) != null) {
            throw IllegalArgumentException()
        }
    }

    private fun validateOperatorContinuously() {
        var count = 0
        operandList.forEach {
            if(Operator.valueOf(code = it) != null) {
                count++
            } else {
                count = 0
            }

            if(count > 1) {
                throw IllegalArgumentException()
            }
        }
    }
}