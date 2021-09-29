package com.example.androidtestsample

import java.util.concurrent.atomic.AtomicInteger

class Counter {
    private var _count = AtomicInteger(0)
    val count
        get() = _count.get()

    fun increase() {
        _count.incrementAndGet()
    }

    fun decrease() {
        _count.decrementAndGet()
    }
}