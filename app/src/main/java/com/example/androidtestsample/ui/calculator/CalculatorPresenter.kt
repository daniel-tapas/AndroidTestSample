package com.example.androidtestsample.ui.calculator

import com.example.androidtestsample.domain.Calculator
import com.example.androidtestsample.domain.Operator

class CalculatorPresenter(
    private val view: CalculatorContract.View,
) : CalculatorContract.Presenter {

    private val calculator = Calculator()

    private var input = ""

    override fun calculate() {
        this.input = calculator.calculate(input).toString()
        view.updateInput(this.input)
    }

    override fun addOperator(operator: Operator) {
        if(input.isBlank()) return
        if(isLastIndexOperator()) return
        input = "$input ${operator.code}"

        view.updateInput(input)
    }

    override fun addNumber(number: Int) {
        if(input.isNotBlank() && isLastIndexOperator()) {
            input = "$input "
        }
        input = "$input$number"

        view.updateInput(input)
    }

    override fun removeLastInput() {
        if(input.isBlank()) return
        input = input.substring(0, input.length - 1).trim()
        view.updateInput(input)
    }

    private fun isLastIndexOperator() = Operator.valueOf(code = input.last().toString()) != null
}