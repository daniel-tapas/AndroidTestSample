package com.example.androidtestsample

import com.google.common.truth.Expect
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.runner.Description
import org.junit.runners.model.Statement

class SoftAssertionTest {

    @Test
    fun assertThat_test() {
        assertThat<Int>(1).isEqualTo(2)
        assertThat<Int>(1).isEqualTo(3)
        assertThat<Int>(1).isEqualTo(4)
    }

    @Test
    fun expect_test() {
        expect {
            that<Int>(1).isEqualTo(2)
            that<Int>(1).isEqualTo(3)
            that<Int>(1).isEqualTo(4)
        }
    }
}

inline fun expect(crossinline f: Expect.() -> Unit) {
    val expect = Expect.create()

    val statement = object : Statement() {
        override fun evaluate() {
            f(expect)
        }
    }

    expect.apply(statement, Description.EMPTY).evaluate()
}