package com.example.androidtestsample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtestsample.databinding.ActivityMainBinding
import com.example.androidtestsample.domain.Counter

// 1. UP 버튼을 누르면 1이 증가한다.
// 2. DOWN 버튼을 누르면 1이 감소한다.
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counter = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchCounterText()

        binding.up.setOnClickListener {
            counter.increase()
            fetchCounterText()
        }

        binding.down.setOnClickListener {
            counter.decrease()
            fetchCounterText()
        }

        // 3. 계산기 액티비티 띄우기
        binding.calculator.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
    }

    private fun fetchCounterText() {
        binding.counter.text = counter.count.toString()
    }
}