package com.example.androidtestsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtestsample.databinding.ActivityMainBinding

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
    }

    private fun fetchCounterText() {
        binding.counter.text = counter.count.toString()
    }
}