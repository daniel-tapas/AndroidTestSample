package com.example.androidtestsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtestsample.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

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
                addInput(plus.text.toString())
            }
            minus.setOnClickListener {
                addInput(minus.text.toString())
            }
            times.setOnClickListener {
                addInput(times.text.toString())
            }
            divide.setOnClickListener {
                addInput(divide.text.toString())
            }

            equals.setOnClickListener {
                // TODO
            }
            remove.setOnClickListener {
                // TODO
            }
        }
    }

    private fun addInput(text: String) {
        binding.input.text = "${binding.input.text}${text}"
    }
}