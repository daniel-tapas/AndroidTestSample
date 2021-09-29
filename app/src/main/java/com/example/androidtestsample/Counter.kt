package com.example.androidtestsample

class Counter {

    private var _count = 0
    val count
        get() = _count

    fun increase() {
        _count++
    }

    fun decrease() {
        _count--
    }
}