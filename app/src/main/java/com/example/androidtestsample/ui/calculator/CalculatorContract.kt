package com.example.androidtestsample.ui.calculator

import com.example.androidtestsample.domain.Operator

interface CalculatorContract {

    interface View {
        fun updateInput(input: String)
    }

    interface Presenter {
        fun calculate()
        fun addOperator(operator: Operator)
        fun addNumber(number: Int)
        fun removeLastInput()
    }
}