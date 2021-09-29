package com.example.androidtestsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtestsample.databinding.ActivityCalculatorBinding
import com.example.androidtestsample.domain.Calculator
import com.example.androidtestsample.domain.Operator

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numList = listOf(
            binding.num0,
            binding.num1,
            binding.num2,
            binding.num3,
            binding.num4,
            binding.num5,
            binding.num6,
            binding.num7,
            binding.num8,
            binding.num9,
        )

        with(binding) {
            numList.forEach { numButton ->
                numButton.setOnClickListener {
                    addInput(numButton.text.toString())
                }
            }

            plus.setOnClickListener {
                addOperator(Operator.PLUS)
            }
            minus.setOnClickListener {
                addOperator(Operator.MINUS)
            }
            times.setOnClickListener {
                addOperator(Operator.TIMES)
            }
            divide.setOnClickListener {
                addOperator(Operator.DIVIDE)
            }

            equals.setOnClickListener {
                input.text = calculator.calculate(input.text.toString()).toString()
            }
            remove.setOnClickListener {
                removeLastIndexInput()
            }
        }
    }

    private fun removeLastIndexInput() {
        binding.input.text = "${
            binding.input.text.substring(0, binding.input.text.length - 1)
                .trim()
        }"
    }

    private fun addInput(text: String) {
        val input = binding.input.text.toString()
        if (input.isNotBlank()) {
            if (Operator.valueOf(code = input.last().toString()) != null) {
                binding.input.text = "$input "
            }
        }
        binding.input.text = "${binding.input.text}${text}"
    }

    private fun addOperator(operator: Operator) {
        if (binding.input.text.isBlank()) return
        addInput(" ${operator.code}")
    }
}