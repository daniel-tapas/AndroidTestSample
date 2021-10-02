package com.example.androidtestsample.ui.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtestsample.databinding.ActivityCalculatorBinding
import com.example.androidtestsample.domain.Operator

class CalculatorActivity : AppCompatActivity(), CalculatorContract.View {

    private lateinit var binding: ActivityCalculatorBinding

    private lateinit var presenter: CalculatorContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CalculatorPresenter(this)

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
            numList.forEachIndexed { index, numButton ->
                numButton.setOnClickListener {
                    presenter.addNumber(index)
                }
            }

            plus.setOnClickListener { presenter.addOperator(Operator.PLUS) }
            minus.setOnClickListener { presenter.addOperator(Operator.MINUS) }
            times.setOnClickListener { presenter.addOperator(Operator.TIMES) }
            divide.setOnClickListener { presenter.addOperator(Operator.DIVIDE) }
            equals.setOnClickListener { presenter.calculate() }
            remove.setOnClickListener { presenter.removeLastInput() }
        }
    }

    override fun updateInput(input: String) {
        binding.input.text = input
    }
}