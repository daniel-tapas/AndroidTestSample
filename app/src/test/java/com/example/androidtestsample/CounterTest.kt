package com.example.androidtestsample

import com.example.androidtestsample.domain.Counter
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

internal class CounterTest {

    lateinit var counter: Counter

    @Before
    fun setUp() {
        counter = Counter()
    }

    @Test
    fun increase_count() {
        counter.increase()
        assertThat(counter.count).isEqualTo(1)
    }

    @Test
    fun decrease_count() {
        counter.decrease()
        assertThat(counter.count).isEqualTo(-1)
    }

    @Test
    fun increase_three_count() {
        repeat(3) {
            counter.increase()
        }
        assertThat(counter.count).isEqualTo(3)
    }

    @Test
    fun decrease_three_count() {
        repeat(3) {
            counter.decrease()
        }
        assertThat(counter.count).isEqualTo(-3)
    }
}