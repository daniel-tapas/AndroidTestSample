package com.example.androidtestsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidtestsample.databinding.ActivityMainBinding

// 1. UP 버튼을 누르면 1이 증가한다.
// 2. DOWN 버튼을 누르면 1이 감소한다.
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.up.setOnClickListener {
            val count = binding.counter.text.toString().toInt()
            binding.counter.text = "${count + 1}"
        }

        binding.down.setOnClickListener {
            val count = binding.counter.text.toString().toInt()
            binding.counter.text = "${count - 1}"
        }
    }
}