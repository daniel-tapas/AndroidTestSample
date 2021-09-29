package com.example.androidtestsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtestsample.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)

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
                    // TODO
                    numButton.text
                }
            }

            plus.setOnClickListener {
                // TODO
            }
            minus.setOnClickListener {
                // TODO
            }
            times.setOnClickListener {
                // TODO
            }
            divide.setOnClickListener {
                // TODO
            }
            equals.setOnClickListener {
                // TODO
            }
            remove.setOnClickListener {
                // TODO
            }
        }
    }
}