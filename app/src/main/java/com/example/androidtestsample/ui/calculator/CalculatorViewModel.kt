package com.example.androidtestsample.ui.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtestsample.domain.Calculator
import com.example.androidtestsample.domain.Operator

class CalculatorViewModel : ViewModel() {

    private val calculator = Calculator()

    private val _input = MutableLiveData("")
    val input: LiveData<String> get() = _input

    private val safeInput: String
        get() = _input.value ?: ""

    fun calculate() {
        _input.value = calculator.calculate(safeInput).toString()
    }

    fun addOperator(operator: Operator) {
        if(safeInput.isBlank()) return
        if(isLastIndexOperator()) return
        _input.value = "$safeInput ${operator.code}"
    }

    fun addNumber(number: Int) {
        if(safeInput.isNotBlank() && isLastIndexOperator()) {
            _input.value = "$safeInput "
        }
        _input.value = "$safeInput$number"
    }

    fun removeLastInput() {
        if(safeInput.isBlank()) return
        _input.value = safeInput.substring(0, safeInput.length - 1).trim()
    }

    private fun isLastIndexOperator() = Operator.valueOf(code = safeInput.last().toString()) != null
}